package controller;

import domain.LottoGame;
import domain.LottoNumber;
import view.InputVeiw;
import view.ResultView;

import java.util.ArrayList;

public class LottoGameMain {

    public static void main(String[] args) {
        int price = InputVeiw.userInput();
        LottoGame lottoGame = new LottoGame(price);

        ArrayList<LottoNumber> lottoNumber = lottoGame.getAutoLottoNumber();
        ResultView.printLottoNumber(lottoNumber);

        int[] winningNumber = InputVeiw.inputPrvLottoNumber();
        int bonusBall = InputVeiw.inputBonusBall();
        lottoGame.showWinningResult(winningNumber, bonusBall);
        ResultView.printResult();
    }
}
