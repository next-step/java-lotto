package camp.nextcamp.edu.lotto.controller;

import java.util.List;
import java.util.Map;

import camp.nextcamp.edu.lotto.entity.Lotto;
import camp.nextcamp.edu.lotto.entity.LottoStore;
import camp.nextcamp.edu.lotto.entity.PurchasedLotto;
import camp.nextcamp.edu.lotto.entity.WinningLotto;
import camp.nextcamp.edu.lotto.module.LottoModule;
import camp.nextcamp.edu.lotto.module.LottoScoreBoardModule;
import camp.nextcamp.edu.lotto.module.WinningScore;
import camp.nextcamp.edu.lotto.views.InputView;
import camp.nextcamp.edu.lotto.views.OutputView;

public class LottoController {
	private final LottoModule lottoModule;
	private final LottoScoreBoardModule scoreBoardModule;

	public LottoController() {
		this.lottoModule = LottoModule.getInstance();
		this.scoreBoardModule = LottoScoreBoardModule.getInstance();
	}

	public void run() {
		final InputView inputView = new InputView();
		final OutputView outputView = new OutputView();

		LottoStore lottoStore = makeLottoStore(inputView);

		PurchasedLotto purchasedLotto = lottoStore.getPurchasedLotto();
		outputView.showLottoCount(purchasedLotto);

		List<Lotto> lottos = purchasedLotto.getLottos();
		outputView.showPurchasedLottos(lottos);
		WinningLotto winningLotto = makeWinningLotto(inputView);

		Map<WinningScore, Long> winning = scoreBoardModule.getWinningScoreBoard(lottos, winningLotto);
		outputView.showResultStatistics(winning);

		double profit = scoreBoardModule.getProfit(winning, lottoStore.getTotalMoney());
		outputView.showProfit(profit);
	}

	private WinningLotto makeWinningLotto(InputView inputView) {
		String lottoNumbers = inputView.getWinningLottoNumbers();
		String bonusNumber = inputView.getBonusNumber();
		return lottoModule.makeWinningLotto(lottoNumbers, bonusNumber);
	}

	private LottoStore makeLottoStore(InputView inputView) {
		String money = inputView.getMoneyString();
		int manualCount = Integer.parseInt(inputView.getManualCount());
		List<String> manualLottos = inputView.getManualLottos(manualCount);

		return new LottoStore(money, manualLottos);
	}
}
