package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoLotteriesFactory {
	public static LottoLotteries createLottoLotteries(List<LottoLottery> manualLottoLotteries,
		List<LottoLottery> autoLottoLotteries) {
		return new LottoLotteries(combine(manualLottoLotteries, autoLottoLotteries));
	}

	private static List<LottoLottery> combine(List<LottoLottery> manualLottoLotteries,
		List<LottoLottery> autoLottoLotteries) {
		List<LottoLottery> combinedLottoLotteries = new ArrayList<>(manualLottoLotteries);
		combinedLottoLotteries.addAll(autoLottoLotteries);

		return combinedLottoLotteries;
	}
}
