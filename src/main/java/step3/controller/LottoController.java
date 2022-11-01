package step3.controller;

import java.util.HashMap;

import step3.exception.BadRequestException;
import step3.model.lotto.Lotto;
import step3.model.lotto.Lottos;
import step3.model.winning.Rank;
import step3.model.winning.WinningResult;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private static final int LOTTE_PRICE = 1000;

	private Lottos purchaseLottos;
	private Lotto winningLotto;
	private WinningResult winningResult;
	private int bonusNumber;

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
		bonusNumber = inputView.getBonusNumber();
		winningResult = new WinningResult(bonusNumber, winningLotto, purchaseLottos);
	}

	public void getWinningStatistics() {
		outputView.printWinningStatisticsHeader();
		HashMap<Rank, Integer>  rankCountMap = winningResult.getCountMap();

		outputView.printWinningStatistics(rankCountMap);

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
