package lotto;

import lotto.domain.LottoBuyingRequest;
import lotto.domain.LottoStore;
import lotto.domain.UserLotto;

public class LottoController {

	public UserLotto buyLotto(LottoBuyingRequest lottoBuyingRequest) {
		LottoStore lottoStore = new LottoStore();

		return lottoStore.buy(lottoBuyingRequest);
	}
}
