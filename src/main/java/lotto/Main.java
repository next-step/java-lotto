package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.domain.Lotto.createLottosOfSize;

public class Main {

    public static void main(String[] args) {
        Lottos lottos = createLottos();
        OutputView.printLottos(lottos);

        Lotto winningLotto = InputView.promptWinningLotto();

        OutputView.printResult(lottos, winningLotto);
    }

    private static Lottos createLottos() {
        int purchaseAmount = InputView.promptPurchaseAmount();
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE + "원 단위로 구매하실 수 있습니다.");
        }
        int lottoSize = purchaseAmount / LOTTO_PRICE;
        return new Lottos(createLottosOfSize(lottoSize));
    }
}
