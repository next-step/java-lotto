package lotto;

import java.util.Collections;
import java.util.List;

public class ResultView {

    public void printPurchaseLottoList(List<List<Integer>> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");

        for (List<Integer> lottery : lotteries) {
            System.out.println(lottery);
        }
    }

    public void printLottoStatistic(List<Statistic> statistics) {
        for (Statistic statistic : Statistic.values()) {
            int frequency = Collections.frequency(statistics, statistic);
            printEachStatistic(statistic, frequency);
        }
    }

    private void printEachStatistic(Statistic statistic, int frequency) {
        StringBuilder sb = new StringBuilder();

        sb.append(statistic.getMatchCount())
                .append("개 일치 = ")
                .append(statistic.getWinnings())
                .append("원 - ")
                .append(frequency)
                .append("개");

        System.out.println(sb);
    }

    public void printTotalRate(double rate) {
        System.out.println("총 수익률은 " + rate + " 입니다.");
    }
}
