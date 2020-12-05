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
                .forEach(r -> System.out.println(r.toString() + lottoResult.getResult().get(r) +"개"));

        System.out.print("총 수익률은 " + String.format("%.2f", lottoResult.getProfitRatio()) + "입니다. ");

        System.out.println(printDescription(lottoResult.getProfitRatio()));
    }

    private String printDescription(double profitRatio) {
        if (profitRatio < 1) return "(기준이 1이기 떄문에 결과적으로 손해라는 의미)";
        return "(기준이 1이기 때문에 결과적으로 이익이라는 의미)";
    }
}
