package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Wallet;

public class LottoService {

    public Wallet buyLotto(int money) {
        Wallet wallet = new Wallet(new Money(money));
        Wallet buyLottoWallet = wallet.purchaseLotto();
        return buyLottoWallet;
    }

    public LottoResult calculateLottoResult(Wallet wallet, Lotto winLotto) {
        return LottoResult.calculateLottoResult(wallet.lottos(), winLotto);
    }

}
