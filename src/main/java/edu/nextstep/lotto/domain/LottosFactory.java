package edu.nextstep.lotto.domain;

import java.util.List;

import edu.nextstep.lotto.domain.sub.Lottos;
import edu.nextstep.lotto.util.NumberUtil;

public class LottosFactory {
	private LottosFactory() {
	}

	public static Lottos createPurchasedLottos(Money money, List<List<Integer>> manualLottoNumbersList) {
		manualLottoNumbersList.addAll(NumberUtil.getRandomLottoNumbersList(money.howManyPurchase()));
		return new Lottos(manualLottoNumbersList);
	}
}