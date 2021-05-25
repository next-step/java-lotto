package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.view.InputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();

    public void lotto(){
        Lotto lotto = new Lotto();
        int buyCount = lotto.buyCount(inputView.money());
        List<LottoNumbers> lottoNumbers = lotto.autoLottoNumbers(buyCount);
    }

}
