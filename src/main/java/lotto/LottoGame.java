package lotto;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        Input input = new Input(new Scanner(System.in));

        Money money = input.inputMoney();
        Output.printLottoCount(money);

        LottoController lottoController = new LottoController(money);
        lottoController.createLotto();


        Lotto winningLotto = new Lotto(input.inputLastWinningNumber());

        LottoNumber bonusNumber = input.inputLastBonusNumber();
        winningLotto.duplicateBonusNumber(bonusNumber);

        WinningLottoResult lottoResult = lottoController.matchLotto(winningLotto, bonusNumber);

        Output.printResultStatic(lottoResult, money.getBuyCount());


    }
}
