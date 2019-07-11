package lottogame.controller;

import lottogame.view.InputView;
import lottogame.domain.LottoGame;
import lottogame.domain.LottoNumber;
import lottogame.domain.LottoResult;
import lottogame.view.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        int price = InputView.userInput();
        List<LottoNumber> lottoManual = InputView.inputManualLottoNumber();
        LottoGame lottoGame = new LottoGame(price,lottoManual);
        ResultView.printLottoNumber(lottoGame.getLotto(),lottoManual.size());

        String winningNumber = InputView.inputPrvLottoNumber();
        int bonusBall = InputView.inputBonusBall();
        LottoResult lottoResult = new LottoResult();
        lottoResult.getWinningResult(lottoGame.getLotto(), winningNumber, bonusBall, price);
        ResultView.printResult(lottoResult);
    }
}
