package wootecam.lotto.core;

import java.util.List;

import wootecam.lotto.model.BonusNumber;
import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;
import wootecam.lotto.model.LottoNumber;
import wootecam.lotto.model.LottoScoreMap;
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
		LottoCount lottoCount = new LottoCount(purchaseMoneyInput);
		this.outputView.printLottoCount(lottoCount);

		if (!lottoCount.isGreaterThanZero()) {
			this.outputView.printExitLottoGame();
			return;
		}

		this.playLotto(lottoCount);
	}

	private void playLotto(LottoCount lottoCount) {
		LottoGameGenerator lottoGameGenerator = new LottoGameGenerator(new AutomaticLottoGenerator());
		List<Lotto> lottos = lottoGameGenerator.getLottos(lottoCount);
		this.outputView.printAutomaticLotto(lottos);

		String winningNumberInput = this.inputView.makeWinningNumberInput();
		Lotto winningLotto = lottoGameGenerator.getWinningLotto(winningNumberInput);

		String bonusNumberInput = this.inputView.makeBonusNumberInput();
		new BonusNumber(new LottoNumber(bonusNumberInput), winningLotto);

		LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();
		LottoScoreMap lottoScoreMap = lottoResultGenerator.getLottoResults(lottos, winningLotto);
		this.outputView.printLottoScoreMap(lottoScoreMap);
		this.outputView.printEarningRate(lottoScoreMap);
		this.inputView.close();
	}
}
