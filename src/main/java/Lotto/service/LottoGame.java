package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.view.InputView;
import Lotto.view.ResultView;

import java.util.List;

public class LottoGame {
    public static void main(String[] args) {
        int purchasedQty = InputView.askHowMuchYouWouldBuy();
        ResultView.printQuantity(purchasedQty);

        List<Lotto> lottos = Lotto.generateLottos(purchasedQty);
        ResultView.printLottos(lottos);
    }
}
