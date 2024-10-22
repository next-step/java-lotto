package step2.service;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoResult;
import step2.domain.LottoShop;
import step2.domain.LottoStast;
import step2.domain.Money;
import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

public class LottoGame {
	public static final int LOTTO_PRICE = 1_000;
	public static final int MAX_LOTTO_PURCHASE_AMOUNT = 100_000;

	public static LottoResult playLotto(Money money) {
		moneyRangeCheck(money);
		LottoResult result = new LottoResult();
		List<Lotto> lotto = LottoShop.buyLottos(money);
		result.addHistory(lotto);
		return result;
	}

	private static void moneyRangeCheck(Money money) {
		if (money.getMoney() < LOTTO_PRICE) {
			throw new NotEnoughMoneyException();
		}
		if (money.getMoney() > MAX_LOTTO_PURCHASE_AMOUNT) {
			throw new MoneyOverLimitException();
		}
	}

	public static LottoStast getLottoStast(LottoResult result, String winningNumbers) {
		return null;
	}
}
