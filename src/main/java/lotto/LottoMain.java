package lotto;


import java.util.List;
import lotto.domain.AutomaticStrategy;
import lotto.domain.Lotto;
import lotto.domain.LottoSeller;
import lotto.domain.ManualStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoSeller lottoSeller = new LottoSeller(money);
        List<Lotto> lottos = lottoSeller.generateLottos(new AutomaticStrategy());
        OutputView.printLottos(lottos);

        String enteredWinningNumbers = InputView.inputWinLotto();
        Lotto winLotto = new ManualStrategy(enteredWinningNumbers).generate();

    }
}
