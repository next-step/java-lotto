package lotto;

import java.util.List;

public class ResultView {

    void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    void showLottos(List<List<Integer>> lottos) {
        for(List lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    void moveLine() {
        System.out.println();
    }

    void showStastics(int[] winResult, int[] winPrice, double percent) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for(int i = 0; i < winResult.length; i++) {
            System.out.println((i + 3) + "개 일치 (" + winPrice[i] + ") - " + winResult[i] + "개");
        }
        System.out.println("총 수익률은 " + percent + "입니다.");
    }
}
