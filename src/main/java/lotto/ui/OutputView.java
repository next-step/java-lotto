package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

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
}
