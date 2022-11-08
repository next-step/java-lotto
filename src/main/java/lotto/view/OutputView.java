package lotto.view;

import lotto.domain.*;

import static lotto.domain.Rank.*;

public class OutputView {

    public static void outputLottos(Lottos lottos) {
        System.out.println("\n수동으로 " + lottos.manualLottoQuantity() + "장, " +
                "자동으로 " + lottos.autoLottoQuantity() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.numbers());
        }
    }

    public static void outputResult(GameResult gameResult) {
        double result = gameResult.result();
        RankCount rankCount = gameResult.rankCount();

        System.out.println("\n당첨 통계\n" +
                "---------");
        System.out.println("3개 일치 (5000원)-"+ rankCount.numberOfRank(FIFTH) + "개");
        System.out.println("4개 일치 (50000원)-"+ rankCount.numberOfRank(FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)-"+ rankCount.numberOfRank(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + rankCount.numberOfRank(SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)-"+ rankCount.numberOfRank(FIRST) + "개");
        System.out.print("총 수익률은 " + result +"입니다.");
        if (result < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
