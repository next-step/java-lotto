package step2;

import java.util.List;

import step2.domain.BonusNumber;
import step2.domain.Lotto;
import step2.domain.LottoStatistics;
import step2.domain.LottoStore;
import step2.domain.Lottos;
import step2.domain.Money;
import step2.domain.WinningLotto;
import step2.ui.InputView;
import step2.ui.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoStore lottoStore = LottoStore.getInstance();

        final Money money = new Money(InputView.inputMoney());
        Lottos lottos = lottoStore.buyLotto(money);
        OutputView.printBuyLotto(lottos);

        final List<Integer> numbers = InputView.inputWinningLottoNumbers();
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(Lotto.convertNumbersToLotto(numbers), bonusNumber);

        LottoStatistics statistics = new LottoStatistics(money, lottos);
        OutputView.printLottoStatistics(winningLotto, statistics);
    }
}
