package step2;

import step2.domain.BonusNumber;
import step2.domain.Lotto;
import step2.domain.LottoStatistics;
import step2.domain.LottoStore;
import step2.domain.Lottos;
import step2.domain.Money;
import step2.domain.WinningLotto;
import step2.dto.LottoDto;
import step2.dto.LottosDto;
import step2.ui.InputView;
import step2.ui.OutputView;

public class LottoApplication {
    private final static LottoStore store = LottoStore.getInstance();

    public static void main(String[] args) {
        final Money money = new Money(InputView.inputMoney());

        final int userPickCount = InputView.inputCountOfUserPickLotto();
        final LottosDto lottosDTO = InputView.inputLottoNumbers(userPickCount);
        final Lottos lottos = store.salesLottos(money, lottosDTO);

        OutputView.printBuyLotto(userPickCount, lottos);

        final LottoDto lottoDTO = InputView.inputWinningLottoNumbers();
        final BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        final WinningLotto winningLotto = new WinningLotto(Lotto.create(lottoDTO.getLottoNumbers()), bonusNumber);

        final LottoStatistics statistics = new LottoStatistics(money, lottos);
        OutputView.printLottoStatistics(winningLotto, statistics);
    }
}
