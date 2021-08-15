package lotto.controller;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.domain.Records;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

	private final int money;
	private Lottos lottos;
	private WinLotto winLotto;

	public LottoController(int money) {
		this.money = money;
	}

	public void buyLotto(int manualLottoCount) {
		final LottoCount lottoCount = new LottoCount(this.money, manualLottoCount);

		ResultView.outputLottoCount(lottoCount);

		this.lottos = Lottos.generateLottos(lottoCount);

		buyManualLotto(lottoCount);
		buyAutoLotto(lottoCount);
	}

	private void buyManualLotto(LottoCount lottoCount) {
		InputView.printManualInputLottoNumbers();

		for (int i = 0; i < lottoCount.getManualLottoCount(); i++) {
			String lottoNumbers = InputView.inputManualLottoNumbers();

			this.lottos.addManualLotto(Lotto.of(lottoNumbers));;
		}
	}

	private void buyAutoLotto(LottoCount lottoCount) {
		for (int i = 0; i < lottoCount.getAutoLottoCount(); i++) {
			ResultView.outputLottoNumbers(this.lottos.addAutoLotto());
		}
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
