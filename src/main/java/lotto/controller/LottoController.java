package lotto.controller;

import lotto.model.Lotto;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();

    public void lotto(){
        Lotto lotto = new Lotto();
        int count = lotto.buyCount(inputView.money());

    }

}
