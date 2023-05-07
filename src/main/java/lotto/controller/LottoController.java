package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class LottoController {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        int lottoCount = inputView.getLottoCount();

        Lotto lotto = new Lotto();
        lotto.playLotto(lottoCount);

    }
}
