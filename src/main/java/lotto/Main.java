package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_PRICE;

public class Main {

    public static void main(String[] args) {
        Lottos lottos = createLottos();

        Lotto winningLotto = InputView.promptWinningLotto();
        int bonusNumber = InputView.promptBonusNumber();
        Lotto.validateBonusNumber(winningLotto, bonusNumber);

        OutputView.printResult(lottos, winningLotto, bonusNumber);
    }

    private static Lottos createLottos() {
        int purchaseAmount = promptPurchaseAmount();

        int totalLottoSize = purchaseAmount / LOTTO_PRICE;
        int manualLottoSize = InputView.promptManualLottoSize();
        int autoLottoSize = totalLottoSize - manualLottoSize;
        if (manualLottoSize > totalLottoSize) {
            throw new IllegalArgumentException("수동 구매하려는 로또가 구입 금액보다 많습니다.");
        }

        List<Lotto> manualLottos = InputView.promptManualLottos(manualLottoSize);
        List<Lotto> autoLottos = Lotto.createLottosOfSize(autoLottoSize);

        Lottos lottos = Lottos.createLottos(manualLottos, autoLottos);
        OutputView.printLottos(lottos, manualLottoSize, autoLottoSize);
        return lottos;
    }

    private static int promptPurchaseAmount() {
        int purchaseAmount = InputView.promptPurchaseAmount();
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE + "원 단위로 구매하실 수 있습니다.");
        }
        return purchaseAmount;
    }

}
