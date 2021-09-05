package step2.view;

import step2.domain.lotto.Lottos;

public class OutputView {
    public void printLottoPurchase(int amount, Lottos issueLottos) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
        System.out.println(issueLottos);
    }

    public void println(Object object) {
        System.out.println(object);
    }
}
