package controller;

import model.Lotto;
import model.LottosInfoFcade;
import model.LottosStatiscsFcade;
import view.input.InputView;

public class LottoController {

    public static void LottoAutoStart() {

        int buyAmount = InputView.inputBuyAmount();

        LottosInfoFcade lottosInfoFcade = new LottosInfoFcade(buyAmount);
        lottosInfoFcade.view();

        Lotto winNum = new Lotto(InputView.inputWinnerLottoNum());

        LottosStatiscsFcade lottosStatiscsFcade = new LottosStatiscsFcade(lottosInfoFcade.getLottos(), winNum, buyAmount);
        lottosStatiscsFcade.view();

    }
}
