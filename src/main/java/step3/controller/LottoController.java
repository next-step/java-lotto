package step3.controller;

import step3.exception.BadRequestException;
import step3.model.Amount;
import step3.model.lotto.Lotto;
import step3.model.lotto.Lottos;
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
	private Amount amount;
	private int bonusNumber;

	public void purchase() {
		amount = new Amount(inputView.getPurchaseAmount());
		final int count = amount.getLottoCount();

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

	public void getBonusNumber() {
		bonusNumber = inputView.getBonusNumber();
	}

	public void getWinningStatistics() {
		outputView.printWinningStatisticsHeader();
		winningResult = new WinningResult(bonusNumber, winningLotto, purchaseLottos);

		outputView.printWinningStatistics(winningResult.getCountMap());
		outputView.printYield(amount.getYield(winningResult.calculatePrize()));
	}

	private boolean isAvailableCount(int count) {
		return count > 0;
	}
}
