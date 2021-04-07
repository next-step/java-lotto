package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPrize;

import java.util.Map;

public class OutputView {
    public void printBoughtLottoCount(int buyAmount) {
        System.out.printf("%s개를 구매했습니다.%n", buyAmount);
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto);
    }

    public void printLine() {
        System.out.println();
    }


    public void printLottoStatistics(Map<LottoPrize, Integer> lottoGameStatistics) {
        System.out.println("당첨 통계");
        for (LottoPrize lottoPrize : lottoGameStatistics.keySet()) {
            System.out.println(String.format("%s개 일치 (%s원)- %s개", lottoPrize.getMatchs(), lottoPrize.getPrize(), lottoGameStatistics.get(lottoPrize)));
        }
    }

    public void printProfit(float profit) {
        StringBuilder message = new StringBuilder("총 수익률은 %1.02f입니다.");
        if (profit < 1) {
            message.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(String.format(String.valueOf(message), profit));
    }
}
