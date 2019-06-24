package step2;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoStatistics;
import step2.domain.LottoStore;
import step2.domain.Money;
import step2.domain.WinningLotto;
import step2.ui.InputView;
import step2.ui.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = InputView.inputMoney();
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLotto(money);
        OutputView.printBuyLotto(lottos);

        WinningLotto winningLotto = InputView.inputWinningLotto();

        LottoStatistics statistics = new LottoStatistics(money, lottos);
        OutputView.printLottoStatistics(winningLotto, statistics);
    }
}
