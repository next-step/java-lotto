package lotto.view;

import lotto.domain.Ticket;

import java.util.List;

public class ResultView {
    public static void printTicketCount(int ticketCount) {
        System.out.printf("%d개를 구매했습니다.", ticketCount);
    }

    public static void printTickeList(List<Ticket> ticketList) {
        ticketList.forEach(t -> System.out.println(t.getLottoNumbers()));
    }
}
