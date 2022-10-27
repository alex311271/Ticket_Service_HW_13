package ru.netology.Manager;

import ru.netology.Comparator.TicketComparator;
import ru.netology.Domain.Ticket;
import ru.netology.Repozitory.Repozitory;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.regex.Pattern.matches;

public class Manager {

    private Repozitory repozitory;
    TicketComparator ticketComparator = new TicketComparator();

    public Manager(Repozitory repozitory) {
        this.repozitory = repozitory;
    }

    public void add(Ticket ticket) {
        repozitory.save((Ticket) ticket);
    }

    public Ticket[] findAllTicket() {
        return repozitory.findAll(ticketComparator);
    }

    public Ticket[] findTowardsTicket(String from, String to){
        Ticket[] result = new Ticket[0];
        for(Ticket ticket: repozitory.findAll(ticketComparator)) {
            if (ticket.getFrom().equalsIgnoreCase(from) && ticket.getTo().equalsIgnoreCase(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) { //
                    tmp[i] = result[i];
                }
                tmp[result.length] = ticket;
                result = tmp;
            }
        }
        return result;
    }

}
