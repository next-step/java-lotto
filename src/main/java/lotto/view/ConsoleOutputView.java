package lotto.view;

import lotto.domain.LottoBundle;
import lotto.domain.LottoMachine;

public class ConsoleOutputView {
    private ConsoleOutputView() {
    }

    public static void printNumberOfAffordableLottos(int money) {
        int numberOfAffordableLottos = LottoMachine.getNumberOfAffordableLottos(money);
        System.out.println(numberOfAffordableLottos + "개를 구매했습니다.");
    }

    public static void printLottos(LottoBundle lottoBundle) {
        lottoBundle.getLottos().forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });

        System.out.println();
    }
}
