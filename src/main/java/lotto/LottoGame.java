package lotto;

import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.result.LottoResult;
import lotto.result.LottoStatistics;

import java.util.List;
import java.util.stream.Collectors;

class LottoGame {

	private final LottoOption lottoOption;
	private final LottoView lottoView;
	private final LottoStore lottoStore;

	LottoGame(LottoOption lottoOption, LottoView lottoView) {
		this.lottoOption = lottoOption;
		this.lottoView = lottoView;
		this.lottoStore = new LottoStore();
	}

	void play() {
		final int money = lottoOption.getMoney();
		List<LottoNumbers> lottoNumbersList = lottoStore.sell(money);
		lottoView.showBuyLottoNumbers(lottoNumbersList);
		WinningNumbers winningNumbers = lottoOption.getWinningNumbers();
		List<LottoResult> lottoResultList = lottoNumbersList.stream()
				.map(winningNumbers::findMatchedResult)
				.collect(Collectors.toList());
		LottoStatistics lottoStatistics = LottoStatistics.create(lottoResultList);
		lottoView.showStatistics(lottoStatistics);
	}
}
