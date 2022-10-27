package ru.netology.Repozitory;

import ru.netology.Domain.Ticket;

import java.util.Arrays;

public class Repozitory {

    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] temp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            temp[i] = tickets[i];
        }
        temp[temp.length - 1] = ticket;
        tickets = temp;
    }

    public void removeId(int id) {
        Ticket[] temp = new Ticket[tickets.length - 1];
        int copyIndex = 0;
        for (Ticket item : tickets) {
            if (item.getId() != id){
                temp[copyIndex] = item;
                copyIndex++;
            }
        }
        tickets = temp;
    }



    public Ticket[] findAll() {
        Arrays.sort(tickets);
        return tickets;
    }
}
