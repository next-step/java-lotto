package controller;

import domain.*;
import view.InputVeiw;
import view.ResultView;

import java.util.List;

public class LottoGameMain {

    public static void main(String[] args) {
        int price = InputVeiw.userInput();
        List<LottoNumber> lottoManual = InputVeiw.inputManualLottoNumber();
        LottoGame lottoGame = new LottoGame(price,lottoManual.size());
        LottoResult lottoResult = new LottoResult();

        List<LottoNumber> lottoAuto = lottoGame.getAutoLottoNumber();
        List<LottoNumber> lottoTotal = ResultView.printLottoNumber(lottoManual,lottoAuto);

        String winningNumber = InputVeiw.inputPrvLottoNumber();
        int bonusBall = InputVeiw.inputBonusBall();
        lottoResult.getWinningResult(lottoTotal, winningNumber, bonusBall, price);
        ResultView.printResult(lottoResult);
    }
}
