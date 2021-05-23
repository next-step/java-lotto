package step3.ui;

import step3.domain.Lotto;

import java.util.List;

public class ResultView {

    public static void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + " 개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); ++i) {
            System.out.println(lottos.get(i));
        }
    }

    public static void showStatistics(int threeCount, int fourCount, int fiveCount, int sixCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원) -" + threeCount + "개");
        System.out.println("4개 일치 (50000원) -" + fourCount + "개");
        System.out.println("5개 일치 (1500000원) -" + fiveCount + "개");
        System.out.println("6개 일치 (2000000000원) -" + sixCount + "개");

    }

    public static void showRate(double earningRate) {
        System.out.println("총 수익률은 " + earningRate + " 입니다.");
    }
}
