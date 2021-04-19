package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoPrize;
import lotto.model.Number;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {
    public void printBoughtLottoCount(int buyAmount) {
        System.out.printf("%s개를 구매했습니다.%n", buyAmount);
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(getLottoNumbers(lotto));
        }
    }

    private String getLottoNumbers(Lotto lotto) {
        StringJoiner lottoNumbers = new StringJoiner(Lotto.DELIMITER, "[", "]");
        for (Number number : lotto.getNumbers()) {
            lottoNumbers.add(number.toString());
        }
        return lottoNumbers.toString();
    }

    public void printLine() {
        System.out.println();
    }


    public void printLottoStatistics(Map<LottoPrize, Integer> lottoGameStatistics) {
        System.out.println("당첨 통계");
        StringBuilder message = new StringBuilder();
        for (LottoPrize lottoPrize : lottoGameStatistics.keySet()) {
            message.setLength(0);
            message.append("%s개 일치");
            if (LottoPrize.SECOND.equals(lottoPrize)) {
                message.append(", 보너스 볼 일치");
            }
            message.append(" (%s원)- %s개%n");
            System.out.printf(message.toString(), lottoPrize.getMatchs(), lottoPrize.getPrize(), lottoGameStatistics.get(lottoPrize));
        }
    }

    public void printProfit(float profit) {
        StringBuilder message = new StringBuilder("총 수익률은 %1.02f입니다.");
        if (profit < 1) {
            message.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.printf((message) + "%n", profit);
    }
}

