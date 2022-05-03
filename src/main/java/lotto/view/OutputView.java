package lotto.view;

import lotto.domain.EarningRate;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPrize;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OutputView {
    private static final String PROFIT = "이득";
    private static final String LOSS = "손해";

    public static void printTickets(LottoTickets lottoTickets) {
        System.out.printf("%s개를 구매했습니다.%n", lottoTickets.size());
        System.out.println(lottoTickets);

        lottoTickets.getLottoTickets().forEach(lottoTicket ->
                printNumbers(lottoTicket.getLottoNumbers().getLottoNumbers())
        );
    }

    private static void printNumbers(List<LottoNumber> lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }

            stringBuilder.append(lottoNumbers.get(i));
        }

        stringBuilder.append("]");

        System.out.println(stringBuilder);
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
                .sorted(Comparator.comparing(LottoPrize::getMatched))
                .forEach(lottoPrize -> {
                    System.out.printf("%s개 일치 (%s원) - %s%n", lottoPrize.getMatched(), lottoPrize.getAmount().getValue(), lottoStatistics.getPrizeCount(lottoPrize));
                });
    }

    private static void printEarningRate(EarningRate earningRate) {
        System.out.printf("총 수익률은 %.2f 입니다.(%s)%n", earningRate.getValue(), getProfit(earningRate));
    }

    private static String getProfit(EarningRate earningRate) {
        if (earningRate.isProfit()) {
            return PROFIT;
        }
        return LOSS;
    }
}
