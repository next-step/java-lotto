package lotto.view;

import lotto.domain.Lottos;

public class ResultView {
    private static final String PURCHASE_RESULT_FORMAT = "%s개를 구매했습니다.";

    public static void printPurchase(Lottos lottos) {
        System.out.println(String.format(PURCHASE_RESULT_FORMAT, lottos.count()));
        lottos.forEach(lotto -> System.out.println(lotto.numbers()));
    }
}
