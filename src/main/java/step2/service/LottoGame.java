package step2.service;

import static step2.domain.LottoShuffleManager.*;
import static step2.domain.var.LottoConstant.*;

import java.util.ArrayList;
import java.util.List;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoStatistics;
import step2.domain.Money;
import step2.dto.LottoPlayResultDto;

public class LottoGame {

	public static LottoPlayResultDto playLotto(Money money) {
		money.checkMaxMoney(MAX_LOTTO_PURCHASE_AMOUNT);
		List<Lotto> lottos = buyLotto(money);
		Money change = money.pay(lottos.size() * LOTTO_PRICE);
		return new LottoPlayResultDto(lottos, change);
	}

	public static LottoStatistics getLottoStast(List<Lotto> lastWeekLottos, String winningNumbers) {
		return new LottoStatistics(lastWeekLottos, new Lotto(LottoNumber.asList(winningNumbers)));
	}

	private static List<Lotto> buyLotto(Money money) {
		int amount = money.getPurchasableCount(LOTTO_PRICE);
		List<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			lottos.add(new Lotto(shuffleSixNumbers()));
		}
		return lottos;
	}
}
