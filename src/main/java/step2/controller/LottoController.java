package step2.controller;

import java.util.HashMap;

import step2.exception.BadRequestException;
import step2.model.lotto.Lotto;
import step2.model.lotto.Lottos;
import step2.model.winning.WinningResult;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private static final int LOTTE_PRICE = 1000;
	private static final int MIN_MATCH_COUNT = 3;
	private static final int MAX_MATCH_COUNT = 6;

	private Lottos purchaseLottos;
	private Lotto winningLotto;
	private WinningResult winningResult;

	public void purchase() {
		final int count = getLottoCount(inputView.getPurchaseAmount());

		if (!isAvailableCount(count)) {
			throw new BadRequestException("입력가능한 최소 구매 금액은 1000 입니다.");
		}
		outputView.printLottoCount(count);

		purchaseLottos = new Lottos(count);
		outputView.printLottos(purchaseLottos);
	}

	public void getWinningNumber() {
		winningLotto = new Lotto(inputView.getWinningNumber());
	}

	public void getWinningStatistics() {
		outputView.printWinningStatisticsHeader();
		winningResult = new WinningResult(winningLotto, purchaseLottos);
		HashMap<Integer, Integer>  countMap = winningResult.getCountMap();

		outputView.printWinningStatistics(countMap);

		double prize = winningResult.getPrize();
		outputView.printYield(prize, purchaseLottos.size() * LOTTE_PRICE);
	}

	private int getLottoCount(int purchaseAmount) {
		return purchaseAmount / LOTTE_PRICE;
	}

	private boolean isAvailableCount(int count) {
		return count > 0;
	}
}
