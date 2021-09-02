package lotto.application;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Wallet;
import lotto.domain.WinLotto;

public class LottoService {

    public Wallet buyLotto(Money money, List<String> manualLottos) {
        Wallet wallet = new Wallet(money);
        Wallet buyLottoWallet = wallet.purchaseLotto(manualLottos);
        return buyLottoWallet;
    }

    public LottoResult calculateLottoResult(Wallet wallet, WinLotto winLotto) {
        return LottoResult.calculateLottoResult(wallet.lottos(), winLotto);
    }

}
