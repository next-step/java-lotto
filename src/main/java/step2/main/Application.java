package step2.main;

import step2.domain.entity.LottoFactory;
import step2.service.LottosIssuance;
import step2.view.InputView;
import step2.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final var money = InputView.inputMoney();
        final var manualQuantity = InputView.inputManualLottoQuantity(money);
        final var manualLotto = InputView.inputManualLotto(manualQuantity);
        final var lottos = LottosIssuance.issues(manualLotto, money);

        OutputView.printLottos(lottos);

        final var lastLottoNumbers = InputView.inputLastLottoNumbers();
        final var bonusNumber = InputView.inputBonusLottoNumber();
        final var winner = LottoFactory.createWinnerLotto(bonusNumber, lastLottoNumbers);
        final var lottoPrizes = lottos.checkLottoPrize(winner);

        OutputView.printWinnerStatistics(lottos, lottoPrizes.getLottoPrizes());
    }
}
