package lotto;


import java.util.List;
import lotto.domain.AutomaticStrategy;
import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.LottoWinningChecker;
import lotto.domain.ManualStrategy;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        int inputValue = InputView.inputMoney();

        LottoSeller lottoSeller = new LottoSeller(new Money(inputValue));
        List<Lotto> lottos = lottoSeller.generateLottos(new AutomaticStrategy());
        OutputView.printLottos(lottos);

        String enteredWinningNumbers = InputView.inputWinLotto();
        String bonusLottoNumber = InputView.inputBonusLottoNumber();
        Lotto winningLotto = new ManualStrategy(enteredWinningNumbers).generate();

        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(lottos, winningLotto);
        OutputView.printStatics(lottoWinningChecker.getRanks(), lottoWinningChecker.getProfitRate());

    }
}
