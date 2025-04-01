package lotto;


import java.util.List;
import lotto.domain.AutomaticStrategy;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoSeller;
import lotto.domain.LottoWinningChecker;
import lotto.domain.ManualStrategy;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        int inputValue = InputView.inputMoney();
        List<String> manualLotto = InputView.inputManualLotto();

        LottoSeller lottoSeller = new LottoSeller(new Money(inputValue));
        List<Lotto> lottos = lottoSeller.generateLottos(new AutomaticStrategy());
        OutputView.printLottos(lottos);

        String enteredWinningNumbers = InputView.inputWinLotto();
        Lotto winningLotto = new ManualStrategy(enteredWinningNumbers).generate();

        String bonusLottoNumber = InputView.inputBonusLottoNumber();
        LottoNumber bonusNumber = new LottoNumber(bonusLottoNumber);

        LottoWinningChecker lottoWinningChecker = new LottoWinningChecker(lottos, winningLotto, bonusNumber);
        OutputView.printStatics(lottoWinningChecker.getRanks(), lottoWinningChecker.getProfitRate());

    }
}
