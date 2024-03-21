package lotto;

import lotto.domain.LotteryShop;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoPlayer {

    private void play() {
        final int cash = InputView.purchasePrice();

        final Lottos lottos = LotteryShop.purchase(cash);
        OutputView.printPurchasedLottos(lottos);

    }

    public static void main(String[] args) {
        final LottoPlayer lottoPlayer = new LottoPlayer();
        lottoPlayer.play();
    }
}
