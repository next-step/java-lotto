package lotto;

import lotto.domain.LottoStore;
import lotto.domain.LottoVendor;
import lotto.domain.Money;
import lotto.domain.UserLotto;

public class LottoController {

	public UserLotto buyLotto(String money) {
		LottoStore lottoStore = new LottoStore();

		return lottoStore.buy(new Money(money));
	}

	public LottoVendor lottoVendor(String winningLottoNumbers, String bonusNumberString) {
		return new LottoVendor(winningLottoNumbers, bonusNumberString);
	}

}
