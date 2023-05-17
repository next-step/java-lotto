package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoApplication {

    public static final int LOTTO_MONEY = 1000;

    public static void main(String[] args) {

        Money money = Money.from(LottoInputView.inputMoney());

        int purchaseNumber = money.calculateNumberOfPurchase(new Money(LOTTO_MONEY));
        LottoOutputView.printPurchaseNumber(purchaseNumber);

        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.purchaseLotto(purchaseNumber);

        LottoOutputView.printLottos(lottos);

        Lotto winLotto = Lotto.from(LottoInputView.inputWinLotto());
        LottoResults results = lottos.matchWinLotto(winLotto);

        LottoOutputView.printLottosResult(results);
    }
}
