package wootecam.lotto.core;

import java.util.ArrayList;
import java.util.List;

import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;
import wootecam.lotto.model.LottoScoreMap;
import wootecam.lotto.model.WinningLotto;
import wootecam.lotto.ui.InputView;
import wootecam.lotto.ui.OutputView;

public class LottoExecutor {

	private final InputView inputView;
	private final OutputView outputView;

	public LottoExecutor() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void start() {
		String purchaseMoneyInput = this.inputView.makeLottoPurchaseMoneyInput();
		String manualLottoCountInput = this.inputView.makeManualLottoCountInput();
		LottoCount lottoCount = new LottoCount(purchaseMoneyInput, manualLottoCountInput);

		if (!lottoCount.isGreaterThanZero()) {
			this.outputView.printExitLottoGame();
			return;
		}

		this.playLotto(lottoCount);
	}

	private void playLotto(LottoCount lottoCount) {
		LottoGameGenerator lottoGameGenerator = new LottoGameGenerator();
		this.outputView.printManualLottoInputMessage();
		List<Lotto> manualLottos = lottoGameGenerator.getLottos(
			new ManualLottoGenerator(this.inputView::makeManualLottoNumbersInput),
			lottoCount.getManualCount());
		List<Lotto> automaticLottos = lottoGameGenerator.getLottos(new AutomaticLottoGenerator(),
			lottoCount.getAutomaticCount());

		List<Lotto> totalLottos = new ArrayList<>();
		totalLottos.addAll(manualLottos);
		totalLottos.addAll(automaticLottos);

		this.outputView.printLottoCount(lottoCount);
		this.outputView.printTotalLottos(totalLottos);

		String winningNumberInput = this.inputView.makeWinningNumberInput();
		String bonusNumberInput = this.inputView.makeBonusNumberInput();
		WinningLotto winningLotto = lottoGameGenerator.getWinningLotto(winningNumberInput, bonusNumberInput);

		LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
		LottoScoreMap lottoScoreMap = lottoResultGenerator.getLottoResults(totalLottos, winningLotto);
		this.outputView.printLottoScoreMap(lottoScoreMap);
		this.outputView.printEarningRate(lottoScoreMap);
		this.inputView.close();
	}
}
