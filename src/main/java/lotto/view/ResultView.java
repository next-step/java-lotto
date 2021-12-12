package lotto.view;

public class ResultView {
    void printLottoCount() {
        System.out.println("개를 구매했습니다.");
    }

    void printMatchingStatistics() {
        System.out.println("당첨 통계\n" +
                "---------");
        System.out.println("3개 일치 (5000원)- 1개");
        System.out.println("총 수익률은 0.35입니다.");
    }
}
