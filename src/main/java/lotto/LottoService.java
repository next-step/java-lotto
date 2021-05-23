package lotto;

import lotto.domain.LottoReport;
import lotto.domain.LottoStore;
import lotto.domain.LottoVendor;
import lotto.domain.Money;
import lotto.domain.UserLotto;

public class LottoService {

	public UserLotto buyLotto(String money) {
		LottoStore lottoStore = new LottoStore();

		return lottoStore.buy(new Money(money));
	}

	public LottoReport report(String winningLottoNumbers, UserLotto userLotto) {
		LottoVendor lottoVendor = new LottoVendor(winningLottoNumbers);

		return lottoVendor.report(userLotto.lottoTickets());
	}

}
