package ru.netology.Repozitory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Comparator.TicketComparator;
import ru.netology.Domain.Ticket;

public class RepozitoryTest {
    TicketComparator travelTimeComparator = new TicketComparator();

    Ticket ticket1 = new Ticket(11, 350, "MOW", "LED", 90);
    Ticket ticket2 = new Ticket(12, 200, "MOW", "LED", 120);
    Ticket ticket3 = new Ticket(13, 300, "MOW", "LED", 100);
    Ticket ticket4 = new Ticket(14, 150, "MOW", "LED", 130);
    Ticket ticket5 = new Ticket(15, 200, "LED", "MOW", 120);
    Ticket ticket6 = new Ticket(16, 200, "LED", "MOW", 130);
    Ticket ticket8 = new Ticket(18, 300, "LED", "MOW", 100);
    Ticket ticket10 = new Ticket(20, 1000, "OGZ", "KUF", 220);
    Ticket ticket12 = new Ticket(22, 500, "OGZ", "KUF", 240);

    @Test

    public void findAll() {
        Repozitory repo = new Repozitory();

        repo.save(ticket1);
        repo.save(ticket5);
        repo.save(ticket10);
        repo.save(ticket12);
        repo.save(ticket8);

        Ticket[] expected = {ticket1, ticket8, ticket5, ticket10, ticket12};
        Ticket[] actual = repo.findAll(travelTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdi(){
        Repozitory repo = new Repozitory();

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.removeId(14);

        Ticket[] expected = {ticket1, ticket3, ticket2, ticket5, ticket6};
        Ticket[] actual = repo.findAll(travelTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}
