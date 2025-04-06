package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import static common.message.OutputMessage.PURCHASED;

public class ResultView {

    public static void printPurchasedLotto(Lottos lottos) {
        System.out.println(lottos.size() + PURCHASED);

        for (Lotto lotto : lottos.getValues()) {
            System.out.println(lotto);
        }
    }
}
