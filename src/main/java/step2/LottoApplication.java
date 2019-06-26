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
        final int directInputCount = InputView.inputCountOfBuyLottoTicket();
        final List<List<Integer>> lottoNumbers = InputView.inputLottoNumbers(directInputCount);

        final Lottos selectedNumberLottos = Lottos.createByNumbers(lottoNumbers);
        Lottos lottos = lottoStore.buyLotto(money, selectedNumberLottos);
        final int countOfselectedLottos = selectedNumberLottos.size();
        OutputView.printBuyLotto(lottos, money, countOfselectedLottos);

        final List<Integer> numbers = InputView.inputWinningLottoNumbers();
        BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(Lotto.convertNumbersToLotto(numbers), bonusNumber);

        LottoStatistics statistics = new LottoStatistics(money, lottos);
        OutputView.printLottoStatistics(winningLotto, statistics);
    }
}
