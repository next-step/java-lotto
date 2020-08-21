package step2.ui;

import step2.domain.Lotto;
import step2.domain.Score;
import step2.domain.WinningInformation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static int totalWinnings = 0;

    public static void outputOfWinningResults(List<WinningInformation> winningInformation, int moneyInput) {
        printEndingMsg();
        Map<Integer, Long> counting = groupByMatchesCounting(winningInformation);
        getBaseMap().forEach((k, v) -> counting.putIfAbsent(k, v));
        counting.forEach((key, value) -> getResultMsg(value, Score.getScore(key)));
        printYields(moneyInput);
    }

    private static Map<Integer, Long> groupByMatchesCounting(List<WinningInformation> winningInformation) {
        Map<Integer, Long> counting = winningInformation.stream()
                .sorted()
                .collect(Collectors.groupingBy(WinningInformation::getNumberOfMatches, Collectors.counting()));
        return counting;
    }

    private static void printEndingMsg() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

    private static HashMap<Integer, Long> getBaseMap() {
        return new HashMap<Integer, Long>() {{
            put(3, 0L);
            put(4, 0L);
            put(5, 0L);
            put(6, 0L);
        }};
    }

    static void getResultMsg(Long value, Score score) {
        totalWinnings += score.getPrize() * value;
        System.out.println(score.getTargetNumber() + "개 일치 (" + score.getPrize() + "원)- " + value + "개");
    }

    public static void printMyGame(List<Lotto> lottos) {
        lottos.forEach((list) -> System.out.println("[" + list.getLotteryPaper() + "]"));
    }

    public static void printYields(int grossMargin) {
        double percent = (double) grossMargin / (double) totalWinnings * 100.0;
        System.out.println("총 수익률은 " + percent + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
