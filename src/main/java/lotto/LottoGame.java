package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.WinningLottoResult;
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


        Lotto winningLotto = input.inputLastWinningNumber();
        LottoNumber bonusNumber = input.inputBonusNumber();

        WinningLottoResult lottoResult = lottoController.matchLotto(winningLotto, bonusNumber);
        Output.printResultStatic(lottoResult, money.getBuyCount());


    }
}
