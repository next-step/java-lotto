package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInputView;

public class LottoApplication {

    public static void main(String[] args) {

        ConsoleInputView consoleInputView = new ConsoleInputView();
        Money moneyToPay = consoleInputView.inputMoneyToPay();

        LottoGenerator lottoGenerator = new LottoAutoGenerator();

        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.buy(moneyToPay, lottoGenerator);

    }

}
