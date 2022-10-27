package ru.netology.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.Domain.Ticket;
import ru.netology.Repozitory.Repozitory;

public class ManagerTest {

    Repozitory repo = new Repozitory();
    Manager manager = new Manager(repo);


    Ticket ticket1 = new Ticket(11, 350, "MOW", "LED", 90);
    Ticket ticket2 = new Ticket(12, 200, "MOW", "LED", 120);
    Ticket ticket3 = new Ticket(13, 300, "MOW", "LED", 100);
    Ticket ticket4 = new Ticket(14, 150, "MOW", "LED", 130);
    Ticket ticket5 = new Ticket(15, 200, "LED", "MOW", 120);
    Ticket ticket6 = new Ticket(16, 200, "LED", "MOW", 130);
    Ticket ticket7 = new Ticket(17, 150, "LED", "MOW", 130);
    Ticket ticket8 = new Ticket(18, 300, "LED", "MOW", 100);
    Ticket ticket9 = new Ticket(19, 350, "LED", "MOW", 90);
    Ticket ticket10 = new Ticket(20, 1000, "OGZ", "KUF", 240);
    Ticket ticket11 = new Ticket(21, 1500, "RUF", "OGZ", 200);
    Ticket ticket12 = new Ticket(22, 500, "OGZ", "KUF", 220);

    @BeforeEach

    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);
    }

    @Test
    public void findAllTicket() {
        Ticket[] expected = {ticket1, ticket9, ticket3, ticket8, ticket2, ticket5, ticket4, ticket6, ticket7,ticket11, ticket12, ticket10};
        Ticket[] actual = manager.findAllTicket();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findTowardsTicket() {

        Ticket[] expected = {ticket1, ticket3, ticket2};
        Ticket[] actual = manager.findTowardsTicket("MOW", "led");
    }

    @Test
    public void findNoTicket() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findTowardsTicket("MOW", "KUF");
    }

    @Test
    public void findOneTicket() {

        Ticket[] expected = {ticket11};
        Ticket[] actual = manager.findTowardsTicket("ruf", "ogz");
    }
}
