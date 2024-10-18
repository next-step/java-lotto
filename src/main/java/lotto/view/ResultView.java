package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String[] PRIZE = {"0", "0", "0", "5000", "50000", "1500000", "2000000000"};

    private ResultView() {
    }

    public static void printPurchaseLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Map<Integer, List<Integer>> lottos) {
        for (int count = 1; count <= lottos.size(); count++) {
            List<Integer> lotto = lottos.get(count);

            Collections.sort(lotto);

            System.out.println(lotto);
        }
        System.out.println();
    }

    public static void printWinningStatics(Map<Integer, Integer> winningStatics) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (int count = 3; count <= 6; count++) {
            System.out.println(count + "개 일치 (" + PRIZE[count] + "원)- " + winningStatics.get(count) + "개");
        }
    }

    public static void printReturnRate(float returnRate) {
        System.out.println("총 수익률은" + " " + String.format("%.2f", returnRate) + "입니다.");
    }
}
