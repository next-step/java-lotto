package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottoes;

public class OutputView {

    public static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public void showPurchaseCount(int count) {
        System.out.println(count + PURCHASE_MESSAGE);
    }

    public void showPurchasedLottoes(Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottoes()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
