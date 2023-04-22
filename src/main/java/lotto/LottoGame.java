package lotto;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.strategy.AutomaticStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    public static void main(String[] args) {
        final LottoMachine lottoMachine = new LottoMachine();

        final Amount amount = new Amount(InputView.purchaseAmount());
        final Lottos lottos = new Lottos(lottoMachine.calculateUnitCount(amount), new AutomaticStrategy());

        OutputView.printLottoCount(lottoMachine.calculateUnitCount(amount));
        OutputView.printLottoNumber(lottoMachine.lottoNumbersDto(lottos));

        final String winningNumbers = InputView.winningNumbers();
        final Lotto winningLotto = lottoMachine.winningLotto(winningNumbers);

        OutputView.printWinningStat(lottoMachine.winningStat(lottos, winningLotto, amount));
    }
}
