package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void outputQuantity(int amount) {
        System.out.println(numberOfLottos(amount) + "개를 구매했습니다.");
    }

    private static int numberOfLottos(int amount) {
        return amount;
    }

    public static void outputLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void outputWinningResult(Map<Rank, Integer> winningResult) {
        for (Map.Entry<Rank, Integer> entry : winningResult.entrySet()) {
            Rank rank = entry.getKey();
            System.out.println(rank.getTitle() + " (" + rank.getPrizeMoney() + "원) - " + entry.getValue() + "개");
        }
    }

    public static void outputRateOfResult(double rateOfResult) {
        System.out.println("총 수익률은 : " + rateOfResult + "입니다.");
    }
}
