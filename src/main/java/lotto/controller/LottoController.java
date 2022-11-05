package lotto.controller;

import lotto.Lotto;
import lotto.Lottos;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    public static void run() {
        Lottos lottos = new Lottos(InputView.inputAmount());
        int manualLottoQuantity = InputView.inputManualLottoQuantity();
        List<Lotto> manualLottos = InputView.inputManualLottoNumbers(manualLottoQuantity);
    }
}
