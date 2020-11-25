package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class ResultView {
    public void printTickets(int tickets) {
        System.out.println(tickets + "개를 구매했습니다 :)");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers().toString()));
    }

    public void printProfitRatio(int profit) {
    }
}
