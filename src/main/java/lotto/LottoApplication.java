package lotto;

import lotto.domain.*;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

public class LottoApplication {

    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();

        Money moneyToPay = inputView.inputMoneyToPay();

        LottoGenerator lottoGenerator = new LottoAutoGenerator();

        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.buy(moneyToPay, lottoGenerator);

        outputView.printLottos(lottos);

        Lotto winningLotto = inputView.inputWinningLotto();


    }

}
