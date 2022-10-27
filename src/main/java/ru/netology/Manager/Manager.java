package ru.netology.Manager;

import ru.netology.Domain.Ticket;
import ru.netology.Repozitory.Repozitory;

import java.util.Arrays;

import static java.util.regex.Pattern.matches;

public class Manager {

    private Repozitory repozitory;

    public Manager(Repozitory repozitory) {
        this.repozitory = repozitory;
    }

    public void add(Ticket ticket) {
        repozitory.save((Ticket) ticket);
    }

    public Ticket[] findAllTicket() {
        return repozitory.findAll();
    }

    public Ticket[] findTowardsTicket(String from, String to){
        Ticket[] result = new Ticket[0];
        for(Ticket ticket: repozitory.findAll()) {
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
