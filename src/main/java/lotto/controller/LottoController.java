package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Records;
import lotto.domain.WinLotto;
import lotto.view.ResultView;

public class LottoController {

	private final int money;
	private Lottos lottos;
	private WinLotto winLotto;

	public LottoController(int money) {
		this.money = money;
	}

	public void buyLotto() {
		final LottoCount lottoCount = new LottoCount(this.money);

		ResultView.outputLottoCount(lottoCount.getLottoCount());
		this.lottos = Lottos.generateAutoLottos(lottoCount.getLottoCount());

		lottos.getLottos()
			.forEach(ResultView::outputLottoNumbers);
	}

	public void winLotto(String winLottoNumbers, int bonusNumber) {
		this.winLotto = WinLotto.of(winLottoNumbers, bonusNumber);
	}

	public Records getRecords() {
		return lottos.toRevenueRecord().aggregate(winLotto);
	}

	public int getMoney() {
		return money;
	}
}
