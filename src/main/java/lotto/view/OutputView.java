package lotto.view;

import lotto.Lottos;

public class OutputView {

    private static final String OUTPUT_MESSAGE_HOW_MANY_LOTTOS_BOUGHT = "%d개를 구매했습니다.";

    public void showHowManyLottosBoughtWithMoney(Lottos lottos) {
        System.out.printf((OUTPUT_MESSAGE_HOW_MANY_LOTTOS_BOUGHT), lottos.count());
    }
}
