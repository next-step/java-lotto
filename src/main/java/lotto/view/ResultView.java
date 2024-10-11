package lotto.view;

import lotto.prize.PrizeCount;
import lotto.number.LottoBalls;
import lotto.prize.LottoPrize;

import java.util.List;

public class ResultView {
    private static final int MIN_WINNING_MATCH_COUNT = 3;

    public void showLottoResult(PrizeCount result) {

        System.out.println("\n당첨 통계");
        System.out.println("---------");

        result.getResults().keySet().stream()
                .filter(matchedLottoNumberCount -> matchedLottoNumberCount >= MIN_WINNING_MATCH_COUNT)
                .forEach(prize ->
                        System.out.printf("%d개 일치 (%d)원- %d개%n",
                                prize,
                                LottoPrize.getPrizeAmount(prize),
                                result.calculateTotalPrize())
                );

    }

    public void showLottoProfit(double profit) {
        System.out.printf("총 수익률은 %f입니다.%n", profit);
    }

    public void showLottoTickets(List<LottoBalls> lottoTickets) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.%n", lottoTickets.size());

        for (LottoBalls lottoBalls : lottoTickets) {
            System.out.println(lottoBalls.toString());
        }

    }
}
