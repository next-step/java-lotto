package lotto;

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
		final int money = lottoOption.getMoney();
		LottoTicket lottoTicket = lottoStore.sell(money);
		lottoView.showLottoTicket(lottoTicket);

		LottoStatistics lottoStatistics = lottoTicket.compareNumbers(lottoOption.getWinningNumbers());
		lottoView.showStatistics(lottoStatistics);
	}
}
