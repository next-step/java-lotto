package lotto;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {

        Money money = Input.inputMoney();

        LottoController lottoController = new LottoController(money, Input.inputSelectLottoCount());

        lottoController.createLottoWithUserInput();
        lottoController.printCountAutoAndSelectGame();
        lottoController.createLottoWithRandom();
        lottoController.printBuyLottoGames();

        WinningLotto winningLotto = Input.inputLastWinningNumber();
        lottoController.matchLotto(winningLotto);

        lottoController.printResultWinningStatic();
        lottoController.printRevenueStatic();


    }
}
