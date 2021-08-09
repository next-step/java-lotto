package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private static final String COUNT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchase(Lottos lottos) {
        printCountOfLotto(lottos);
        printLottosNumber(lottos);
    }

    private static void printCountOfLotto(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + COUNT_PURCHASE_AMOUNT_MESSAGE);
    }

    private static void printLottosNumber(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
