package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void printLotto(List<Lotto> list) {
        for (Lotto lotto : list) {
            System.out.println(lotto.toString());
        }
    }

    public static void printResultStatus(List<Lotto> lottoList, final Integer[] winningNumbers) {
        Map<Integer, Integer> resultCounts = new HashMap<>();
        lottoList.stream()
            .map(lotto -> lotto.getResult(winningNumbers))
            .filter(matches -> matches > 2)
            .forEach(matches ->
                resultCounts.put(matches, resultCounts.getOrDefault(matches, 0) + 1)
            );

        System.out.println("당첨 통계");
        System.out.println("---------");
        printMatchStatistics(resultCounts);

        System.out.println("총 수익률은 " + getProfitRatio(resultCounts, lottoList.size()) + "입니다.");

    }

    private static void printMatchStatistics(Map<Integer, Integer> resultCounts){
        Lottery.prize.entrySet().stream()
            .map(entry ->
                entry.getKey() + "개 일치(" + entry.getValue() + "원)- "
                    + resultCounts.getOrDefault(entry.getKey(), 0) + "개"
            )
            .forEachOrdered(System.out::println);
    }

    private static double getProfitRatio(Map<Integer, Integer> resultCounts, int ticketCount) {
        int profit = resultCounts.entrySet().stream()
            .map(entry -> entry.getValue() * Lottery.prize.get(entry.getKey()))
            .reduce(0, Integer::sum);

        int cost = ticketCount * Lottery.price;

        return Math.round(profit / cost * 100.0d) / 100.0d;

    }


}
