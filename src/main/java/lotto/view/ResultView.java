package lotto.view;

import lotto.number.LottoBalls;
import lotto.prize.LottoPrize;
import lotto.prize.PrizeCountMap;

import java.util.Comparator;
import java.util.List;

public class ResultView {
    private static final int MIN_WINNING_MATCH_COUNT = 3;

    public void showLottoResult(PrizeCountMap result) {

        System.out.println("\n당첨 통계");
        System.out.println("---------");

        result.getResults().entrySet().stream()
                .filter(entry -> entry.getKey().isWinningPrize(MIN_WINNING_MATCH_COUNT))
                .sorted(Comparator.comparing(entry -> entry.getKey().getPrizeAmount()))
                .forEach(entry -> {
                    LottoPrize lottoPrize = entry.getKey();
                    int matchedTicketCount = entry.getValue();
                    System.out.printf("%d개 일치 %s(%d원) - %d개%n",
                            lottoPrize.getMatchedLottoNumbers(),
                            lottoPrize.isBonusNeed() ? ",보너스 볼 일치" : "",
                            lottoPrize.getPrizeAmount(),
                            matchedTicketCount);
                });

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
