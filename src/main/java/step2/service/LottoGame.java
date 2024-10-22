package step2.service;

import static step2.domain.var.LottoConstant.*;

import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoShop;
import step2.domain.LottoStast;
import step2.domain.Money;
import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

public class LottoGame {

	public static List<Lotto> playLotto(Money money) {
		moneyRangeCheck(money);
		return LottoShop.buyLottos(money);
	}

	private static void moneyRangeCheck(Money money) {
		if (money.getMoney() < LOTTO_PRICE) {
			throw new NotEnoughMoneyException();
		}
		if (money.getMoney() > MAX_LOTTO_PURCHASE_AMOUNT) {
			throw new MoneyOverLimitException();
		}
	}

	public static LottoStast getLottoStast(List<Lotto> result, String winningNumbers) {
		return new LottoStast(result, LottoNumber.listFrom(winningNumbers));
	}
}
