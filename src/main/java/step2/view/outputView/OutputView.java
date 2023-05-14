package step2.view.outputView;

import step2.Ticket;

import java.util.List;

public class OutputView {

    public static void printTickets(List<Ticket> tickets){
        printTicketCount(tickets.size());
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getTicket());
        }
    }

    public static void printTicketCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }
}
