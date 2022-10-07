package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        Money purchaseAmount = InputView.inputPurchaseAmount();
        int numberOfLottos = purchaseAmount.divideBy(Lotto.PRICE);
        List<Lotto> purchasedLottos = LottoFactory.createLottos(numberOfLottos);
        OutputView.printPurchasedLottos(purchasedLottos);
    }

}
