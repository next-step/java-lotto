package lotto.view;

import lotto.domain.EarningRate;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrize;
import lotto.domain.LottoStatistics;
import lotto.domain.LottoTicketType;
import lotto.domain.LottoTickets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String PROFIT = "이득";
    private static final String LOSS = "손해";

    private OutputView() {
    }

    public static void printTickets(LottoTickets lottoTickets) {
        System.out.printf("수동으로 %s장, 자동으로 %s장을 구매했습니다.%n", lottoTickets.size(LottoTicketType.MANUAL), lottoTickets.size(LottoTicketType.AUTO));

        lottoTickets.getLottoTickets().forEach(lottoTicket ->
                printNumbers(lottoTicket.getLottoNumbers())
        );
    }

    private static void printNumbers(LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        printMatchedPrizes(lottoStatistics);
        printEarningRate(lottoStatistics.getEarningRate());
    }

    private static void printMatchedPrizes(LottoStatistics lottoStatistics) {
        List<LottoPrize> lottoPrizes = Arrays.asList(LottoPrize.values());
        Collections.reverse(lottoPrizes);

        lottoPrizes.stream()
                .filter(lottoPrize -> lottoPrize != LottoPrize.NONE)
                .forEach(lottoPrize -> {
                    printMatch(lottoPrize);
                    System.out.printf("(%s원) - %s%n", lottoPrize.getAmount(), lottoStatistics.getPrizeCount(lottoPrize));
                });
    }

    private static void printMatch(LottoPrize lottoPrize) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottoPrize.getMatch());
        stringBuilder.append("개 일치");

        if (lottoPrize.hasBonusNumber()) {
            stringBuilder.append(", 보너스볼 일치");
        }

        System.out.print(stringBuilder);
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
