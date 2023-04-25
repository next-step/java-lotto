package lotto.View;

import java.util.List;

import lotto.Model.Ticket;


public class ResultView {
    public static void printTickets(List<Ticket> ticketList) {
        for (Ticket ticket : ticketList) {
            System.out.println(ticket.numbers());
        }
        System.out.println();
    }
}
