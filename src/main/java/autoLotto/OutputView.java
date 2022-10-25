package autoLotto;

import java.util.Map;

import static autoLotto.Rank.*;

public class OutputView {

    public static void outputQuantity(Lottos lottos) {
        System.out.println(lottos.getQuantity() + "개를 구매했습니다.");
    }

    public static void outputLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLotto());
        }
    }

    public static void outputResult(GameResult gameResult) {
        double result = gameResult.getResult();
        Map<Rank, Integer> rankCount = gameResult.getRankCount();

        System.out.println("\n당첨 통계\n" +
                "---------");
        System.out.println("3개 일치 (5000원)-"+ rankCount.get(FIFTH) + "개");
        System.out.println("4개 일치 (50000원)-"+ rankCount.get(FOURTH) + "개");
        System.out.println("5개 일치 (1500000원)-"+ rankCount.get(THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원)-" + rankCount.get(SECOND) + "개");
        System.out.println("6개 일치 (2000000000원)-"+ rankCount.get(FIRST) + "개");
        System.out.print("총 수익률은 " + result +"입니다.");
        if (result < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
