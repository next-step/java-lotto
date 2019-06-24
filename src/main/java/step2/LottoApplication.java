package step2;

import step2.domain.BonusNumber;
import step2.domain.LottoStatistics;
import step2.domain.LottoStore;
import step2.domain.Lottos;
import step2.domain.Money;
import step2.domain.WinningLotto;
import step2.ui.InputView;
import step2.ui.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        Money money = InputView.inputMoney();
        LottoStore lottoStore = new LottoStore();
        Lottos lottos = lottoStore.buyLotto(money);
        OutputView.printBuyLotto(lottos);

        WinningLotto winningLotto = InputView.inputWinningLotto();
        BonusNumber bonusNumber = InputView.inputBonusNumber();

        LottoStatistics statistics = new LottoStatistics(money, lottos);
        OutputView.printLottoStatistics(winningLotto.addBounsNumber(bonusNumber), statistics);
    }
}
