package step2.view;

import step2.domain.lotto.Lottos;
import step2.domain.statistics.Amount;

public class OutputView {
    public void printLottoPurchase(Amount amount, Lottos issueLottos) {
        System.out.println(amount);
        System.out.println(issueLottos);
    }

    public void println(Object object) {
        System.out.println(object);
    }
}
