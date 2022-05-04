package lotto.view;

import lotto.domain.EarningRate;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrize;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.Comparator;

public class OutputView {
    private static final String PROFIT = "이득";
    private static final String LOSS = "손해";

    private OutputView() {
    }

    public static void printTickets(LottoTickets lottoTickets) {
        System.out.printf("%s개를 구매했습니다.%n", lottoTickets.size());

        lottoTickets.getLottoTickets().forEach(lottoTicket ->
                printNumbers(lottoTicket.getLottoNumbers())
        );
    }

    private static void printNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers());
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printMatchedPrizes(lottoStatistics);
        printEarningRate(lottoStatistics.getEarningRate());
    }

    private static void printMatchedPrizes(LottoStatistics lottoStatistics) {
        Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize != LottoPrize.NONE)
                .sorted(Comparator.comparing(LottoPrize::getMatch))
                .forEach(lottoPrize -> {
                    System.out.printf("%s개 일치 (%s원) - %s%n", lottoPrize.getMatch(), lottoPrize.getAmount(), lottoStatistics.getPrizeCount(lottoPrize));
                });
    }

    private static void printEarningRate(EarningRate earningRate) {
        System.out.printf("총 수익률은 %.2f 입니다.(%s)%n", earningRate.getEarningRate(), getProfit(earningRate));
    }

    private static String getProfit(EarningRate earningRate) {
        if (earningRate.isProfit()) {
            return PROFIT;
        }
        return LOSS;
    }
}
