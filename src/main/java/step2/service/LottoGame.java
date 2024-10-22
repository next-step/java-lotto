package step2.service;

import static step2.domain.LottoShuffleManager.*;
import static step2.domain.var.LottoConstant.*;

import java.util.ArrayList;
import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoStast;
import step2.domain.Money;
import step2.dto.LottoPlayResultDto;
import step2.exception.MoneyOverLimitException;
import step2.exception.NotEnoughMoneyException;

public class LottoGame {

	public static LottoPlayResultDto playLotto(Money money) {
		moneyRangeCheck(money);
		List<Lotto> lottos = buyLotto(money);
		Money change = money.pay(lottos.size() * LOTTO_PRICE);
		return new LottoPlayResultDto(lottos, change);
	}

	public static List<Lotto> buyLotto(Money money) {
		int amount = Lotto.getAmountByMoney(money);
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			lottos.add(new Lotto(shuffleSixNumbers()));
		}
		return lottos;
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
