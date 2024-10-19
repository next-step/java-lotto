package lotto.view;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void printLottoAmount(int amount) {
        System.out.println("총" + amount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> selectedNumbers) {
        System.out.println(selectedNumbers);
    }

    public static void printResult() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-".repeat(10));
    }

    public static void printMatchCount(int prizeCount, int prizeMoney, int matchCount) {
        System.out.printf(prizeCount + "개 일치 (" + prizeMoney + "원) - " + matchCount + "개");
        System.out.println();
    }

}
