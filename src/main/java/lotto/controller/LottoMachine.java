package lotto.controller;

import lotto.Lottos;
import lotto.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachine {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int moneyForLotto = inputView.showMessageAndGetMoneyInput();
        Money money = new Money(moneyForLotto);
        Lottos lottos = Lottos.buy(money);

        outputView.showHowManyLottosBoughtWithMoney(lottos);


    }
}
