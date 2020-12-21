package lotto;

import lotto.option.LottoOption;
import lotto.result.LottoStatistics;

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
		LottoTicket lottoTicket = lottoStore.sell(lottoOption.getMoney());
		lottoView.showLottoTicket(lottoTicket);

		LottoStatistics lottoStatistics = lottoTicket.compareNumbers(lottoOption.getWinningNumbers());
		lottoView.showStatistics(lottoStatistics);
	}
}
