package lotto;

import java.util.Map;

public class OutputView {

    private OutputView() {}

    public static final Map<String, Long> WINNING_PRIZE = Map.of(
        WinningNumbers.FIRST_GRADE, 2_000_000_000L,
        WinningNumbers.SECOND_GRADE, 1_500_000L,
        WinningNumbers.THIRD_GRADE, 50_000L,
        WinningNumbers.FOURTH_GRADE, 5_000L
    );

    public static void printRanking(Map<String, Integer> result, int amount) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + result.get(WinningNumbers.FOURTH_GRADE) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(WinningNumbers.THIRD_GRADE) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(WinningNumbers.SECOND_GRADE) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(WinningNumbers.FIRST_GRADE) + "개");
        Double sum = 0.0;
        for (String key : result.keySet()) {
            sum += (result.get(key) * WINNING_PRIZE.get(key));
        }
        System.out.println("총 수익률은 " + sum / amount + "입니다.");
    }

}
