package lotto.application;

import lotto.domain.LottoLottery;
import lotto.domain.Message;
import lotto.domain.Money;

public class LottoService {
	private final Money money;

	public LottoService(Money money) {
		this.money = money;
	}

	public int buyLotto() {
		int count = money.buyMax(LottoLottery.getPrice());
		validateBuyLotto(count);

		return count;
	}

	private void validateBuyLotto(int count) {
		if (count == 0) {
			throw new IllegalArgumentException(Message.INVALID_BUY_LOTTO);
		}
	}
}
