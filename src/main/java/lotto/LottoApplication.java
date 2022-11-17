package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoStore;
import lotto.service.WinningLotto;

public class LottoApplication {
    public static void main(String[] args) {
        LottoController controller = new LottoController();

        LottoStore lottoStore = controller.createLotto();
        controller.printLotto(lottoStore.getLotto());
        WinningLotto winningLotto = controller.registerWinningLotto();
        controller.resultLotto(winningLotto, lottoStore);
    }
}
