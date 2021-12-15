package lotto;

import lotto.domain.*;
import lotto.view.MoneyInputView;

public class LottoApplication {

    public static void main(String[] args) {

        MoneyInputView moneyInputView = new MoneyInputView();
        Money moneyToPay = moneyInputView.inputMoneyToPay();

        LottoGenerator lottoGenerator = new LottoAutoGenerator();

        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.buy(moneyToPay, lottoGenerator);

    }

}
