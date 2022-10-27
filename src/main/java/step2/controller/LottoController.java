package step2.controller;

import java.util.HashMap;

import step2.exception.BadRequestException;
import step2.model.lotto.Lotto;
import step2.model.lotto.Lottos;
import step2.model.lotto.WinningAmount;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private static final int LOTTE_PRICE = 1000;
	private static final int MIN_MATCH_COUNT = 3;
	private static final int MAX_MATCH_COUNT = 6;

	private Lottos lottos;
	private Lotto winningLotto;

	public void purchase() {
		final int count = getLottoCount(inputView.getPurchaseAmount());

		if (!isAvailableCount(count)) {
			throw new BadRequestException("입력가능한 최소 구매 금액은 1000 입니다.");
		}
		outputView.printLottoCount(count);

		lottos = new Lottos(count);
		outputView.printLottos(lottos);
	}

	public void getWinningNumber() {
		winningLotto = new Lotto(inputView.getWinningNumber());
	}

	public void getWinningStatistics() {
		outputView.printWinningStatisticsHeader();
		HashMap<Integer, Integer>  countMap = lottos.getMatchCountMap(winningLotto);

		double prize = getPrize(countMap);
		outputView.printYield(prize, lottos.size() * LOTTE_PRICE);
	}

	private int getLottoCount(int purchaseAmount) {
		return purchaseAmount / LOTTE_PRICE;
	}

	private double getPrize(HashMap<Integer, Integer> countMap) {
		double prize = 0;

		for (int matchCount = MIN_MATCH_COUNT; matchCount < MAX_MATCH_COUNT + 1; matchCount++) {
			WinningAmount winningAmount = WinningAmount.findByMatchCount(matchCount);
			prize += winningAmount.getPrize() * countMap.get(winningAmount.getMatchCount());
			outputView.printWinningStatistics(winningAmount, countMap.get(winningAmount.getMatchCount()));
		}
		return prize;
	}

	private boolean isAvailableCount(int count) {
		return count > 0;
	}
}
