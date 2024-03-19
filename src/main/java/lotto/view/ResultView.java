package lotto.view;

import lotto.domain.LottoTickets;

public class ResultView {
    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        lottoTickets.getLottoTicketList().forEach(System.out::println);
        System.out.println();
    }

}
