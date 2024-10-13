package lotto.view;

import lotto.domain.number.LottoNumber;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.WinningPrize;
import lotto.domain.sales.LottoBill;
import lotto.domain.sales.LottoBundle;

import java.util.stream.Collectors;

public class ResultView {

    private static final String BELOW_ONE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String OVER_ONE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";

    public void show(LottoBundle lottoBundle) {
        for (int i = 0; i < lottoBundle.count(); i++) {
            System.out.println(lottoBundle.lotto(i).lottoNumbers().stream()
                    .sorted()
                    .map(LottoNumber::toString)
                    .collect(Collectors.joining(", ", "[", "]")));
        }
    }

    public void report(WinningPrize winningPrize, LottoBill bill) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------------------");
        printPrizes(winningPrize);
        printProfit((double) winningPrize.totalPrize() / bill.salesAmount());
    }

    private void printPrizes(WinningPrize winningPrize) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            printPrize(winningPrize, lottoPrize);
        }
    }

    private void printPrize(WinningPrize winningPrize, LottoPrize lottoPrize) {
        if (lottoPrize != LottoPrize.NOTHING) {
            System.out.println(matchComment(lottoPrize.getMatch())
                    + "," + bonusComment(lottoPrize.isBonus())
                    + " (" + lottoPrize.getPrize() + "원)- "
                    + winningPrize.winAmount(lottoPrize) + "개");
        }
    }

    private String matchComment(int match) {
        return match + "개 일치";
    }

    private String bonusComment(boolean isBonus) {
        return isBonus ?  "보너스볼 일치" : "";
    }

    private void printProfit(double winningRate) {
        System.out.println("총 수익률은 "
                + String.format("%.2f", winningRate)
                + "입니다."
                + profitComment(winningRate));
    }

    private String profitComment(double winningRate) {
        return (winningRate > 1.0) ? OVER_ONE : BELOW_ONE;
    }
}
