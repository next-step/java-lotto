package lottogame.controller;

import lottogame.domain.*;
import lottogame.view.InputView;
import lottogame.view.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        int price = InputView.userInput();
        List<LottoNumber> lottoManual = InputView.inputManualLottoNumber();
        LottoGame lottoGame = new LottoGame(price, lottoManual);
        ResultView.printLottoNumber(lottoGame.getLotto(), lottoManual.size());

        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(InputView.inputPrvLottoNumber(), InputView.inputBonusBall());
        LottoResult lottoResult = new LottoResult();
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        ResultView.printResult(lottoResult);
    }
}
