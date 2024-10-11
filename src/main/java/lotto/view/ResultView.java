package lotto.view;

import lotto.prize.Prize;
import lotto.result.LottoResult;
import lotto.ticket.LottoTicket;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int MIN_WINNING_MATCH_COUNT = 3;

    public void showLottoResult(Map<LottoResult, Integer> result) {

        System.out.println("\n당첨 통계");
        System.out.println("---------");

        result.keySet().stream()
                .filter(lottoResult -> lottoResult.getMatchedLottoNumbersCount() >= MIN_WINNING_MATCH_COUNT)
                .forEach(lottoResult ->
                        System.out.printf("%d개 일치 (%d)원- %d개%n",
                                lottoResult.getMatchedLottoNumbersCount(),
                                Prize.getPrizeAmount(lottoResult.getMatchedLottoNumbersCount()),
                                result.get(lottoResult))
                );


    }

    public void showLottoProfit(double profit) {
        System.out.printf("총 수익률은 %f입니다.%n", profit);
    }

    public void showLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());

        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }

    }
}
