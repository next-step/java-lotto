package lotto.controller;

import lotto.Lottos;
import lotto.view.InputView;

public class LottoController {
    public static void run() {
        Lottos lottos = new Lottos(InputView.inputAmount());
    }
}
