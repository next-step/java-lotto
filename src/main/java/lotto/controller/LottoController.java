package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        int lottoCount = inputView.getLottoCount();

        Lotto lotto = new Lotto();
        lotto.playLotto(lottoCount);

        ResultView.printLottoNumber();

        WinningNumber.stringToNumber(inputView.inputWinningLottoNumbers());
    }
}
