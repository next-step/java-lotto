package Lotto.view;

import Lotto.domain.Lotto;

import java.util.List;

public class ResultView {
    public static void printQuantity(int quantity) {
        System.out.println(quantity+"개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
