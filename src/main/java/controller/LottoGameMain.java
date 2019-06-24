package controller;

import domain.LottoGame;
import view.InputVeiw;

public class LottoGameMain {

    public static void main(String[] args) {
        int numofLotto = InputVeiw.userInput();

        LottoGame.run(numofLotto);
        LottoGame.showResult();
    }
}
