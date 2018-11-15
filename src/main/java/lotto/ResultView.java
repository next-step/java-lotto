package lotto;

import java.util.List;

public class ResultView {

    static void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    static void showLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    static void moveLine() {
        System.out.println();
    }

    static void showStatistics(List<Integer> winResult, List<Integer> winPrice, double percent) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for(int i = 0; i < winResult.size(); i++) {
            System.out.println((i + 3) + "개 일치 (" + winPrice.get(i) + ") - " + winResult.get(i) + "개");
        }
        System.out.println("총 수익률은 " + percent + "입니다.");
    }
}
