package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public abstract class ResultView {

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printLottos(Lottos lottos) {
        int purchasedLotto = lottos.numberOfLotto();
        System.out.printf("%d개를 구매했습니다.\n", purchasedLotto);
        for (Lotto lotto : lottos.lottos()) {
            System.out.println(lotto.toString());
        }
        ResultView.println("");
    }

}
