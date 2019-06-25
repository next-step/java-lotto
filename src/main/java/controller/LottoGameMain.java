package controller;

import domain.LottoGame;
import view.InputVeiw;

public class LottoGameMain {

    public static void main(String[] args) {
        int price = InputVeiw.userInput();

        LottoGame lottoGame = new LottoGame(price);
        lottoGame.run();
        lottoGame.showResult();
    }
}
