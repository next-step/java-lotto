package lotto;

import lotto.domain.*;
import lotto.domain.stat.LottoResult;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;

import java.util.stream.Collectors;

public class LottoApplication {

    public static void main(String[] args) {
        ConsoleInputView inputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();

        Money moneyToPay = new Money(inputView.inputMoneyToPay());

        LottoGenerator lottoGenerator = new LottoAutoGenerator();
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.buy(moneyToPay, lottoGenerator);

        outputView.printLottos(lottos);

        Lotto winningLotto = new Lotto(inputView.inputWinningLottoNumbers()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        LottoResult result = LottoResult.generate(lottos, winningLotto, moneyToPay);

        outputView.showResult(result);
    }

}
