package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    public void printTickets(int tickets) {
        System.out.println(tickets + "개를 구매했습니다 :)");
    }

    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers().toString()));
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Arrays.stream(Rank.values())
                .filter(r -> r.getMatchingScore() >= 3)
                .sorted(Comparator.comparing(Rank::getProfit))
                .forEach(r -> System.out.println(r.getMatchingScore() +
                        "개 일치 (" + r.getProfit() + "원)" + ": " + lottoResult.getResult().get(r) +"개"));

        System.out.println("총 수익률은 " + String.format("%.2f", lottoResult.getProfitRatio()) + "입니다.");
    }
}
