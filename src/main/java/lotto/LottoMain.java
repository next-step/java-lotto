package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lottos;

public class LottoMain {

    public static void main(String[] args) {
        LottoController controller = new LottoController();
        Lottos lottos = controller.buy();

        controller.check(lottos);
    }
}
