package step2;

import step2.domain.AutoPickLottosFactory;
import step2.domain.BonusNumber;
import step2.domain.Lotto;
import step2.domain.LottoStatistics;
import step2.domain.LottoStore;
import step2.domain.Lottos;
import step2.domain.Money;
import step2.domain.UserPickLottosFactory;
import step2.domain.WinningLotto;
import step2.dto.LottoDTO;
import step2.dto.LottosDTO;
import step2.ui.InputView;
import step2.ui.OutputView;

public class LottoApplication {
    private final static LottoStore store = LottoStore.getInstance();

    public static void main(String[] args) {
        final Money money = new Money(InputView.inputMoney());

        final int userPickCount = InputView.inputCountOfUserPickLotto();
        final LottosDTO lottosDTO = InputView.inputLottoNumbers(userPickCount);
        final Lottos autoPickLottos = store.salesLottos(money, lottosDTO, new UserPickLottosFactory());

        final Money usedMoney = autoPickLottos.getTotalPrice();
        final Money restMoney = money.subtractMoney(usedMoney);
        final Lottos userPickLottos = store.salesLottos(restMoney, new AutoPickLottosFactory());

        OutputView.printBuyLotto(autoPickLottos, userPickLottos);

        final LottoDTO lottoDTO = InputView.inputWinningLottoNumbers();
        final BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNumber());
        final WinningLotto winningLotto = new WinningLotto(Lotto.create(lottoDTO.getLottoNumbers()), bonusNumber);

        final Lottos lottos = autoPickLottos.addAll(userPickLottos);
        final LottoStatistics statistics = new LottoStatistics(money, lottos);
        OutputView.printLottoStatistics(winningLotto, statistics);
    }
}
