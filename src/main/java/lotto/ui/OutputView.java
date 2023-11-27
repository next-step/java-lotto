package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Map;

public class OutputView {

    public static void outputQuantity(final int manualQuantity, final int autoQuantity) {
        System.out.println("수동으로 " + manualQuantity + "장, 자동으로 " + autoQuantity + "장을 구매했습니다.");
    }

    public static void outputLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public static void outputWinningResult(Map<Rank, Integer> winningResult) {
        for (Map.Entry<Rank, Integer> entry : winningResult.entrySet()) {
            Rank rank = entry.getKey();
            System.out.println(rank.getTitle() + " (" + rank.getPrizeMoney() + "원) - " + entry.getValue() + "개");
        }
    }

    public static void outputRateOfResult(final double rateOfResult) {
        System.out.println("총 수익률은 : " + rateOfResult + "입니다.");
    }
}
