package step2.controller;

import java.util.HashMap;

import step2.model.lotto.Lotto;
import step2.model.lotto.Lottos;
import step2.model.lotto.WinningAmount;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private static final int LOTTE_PRICE = 1000;

	private Lottos lottos;
	private Lotto winningLotto;
	private HashMap<Integer, Integer> countMap;

	public void purchase() {
		final int count = getLottoCount(inputView.getPurchaseAmount());
		outputView.printLottoCount(count);

		lottos = new Lottos(count);
		outputView.printLottos(lottos);
	}

	public void getWinningNumber() {
		winningLotto = new Lotto(inputView.getWinningNumber());
	}

	public void getWinningStatistics() {
		double yeild = 0;
		outputView.printWinningStatisticsHeader();

		countMap = lottos.getMatchCountMap(winningLotto);
		for (int i = 3; i <= 6; i++) {
			WinningAmount winningAmount = WinningAmount.findByMatchCount(i);
			yeild += winningAmount.getPrize() * countMap.get(winningAmount.getMatchCount());
			outputView.printWinningStatistics(winningAmount, countMap.get(winningAmount.getMatchCount()));
		}
		yeild /= lottos.size() * LOTTE_PRICE;

		outputView.printYield(yeild);
	}

	private int getLottoCount(int purchaseAmount) {
		return purchaseAmount / LOTTE_PRICE;
	}
}
