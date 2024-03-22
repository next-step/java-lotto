package lotto.view;

import lotto.domain.MyLottos;

public class LottoManager {
	private final InputView inputView;
	private final OutputView outputView;

	public LottoManager(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Integer pay = inputView.inputPay();
		MyLottos myLottos = outputView.printBuyLottos(pay);
		String winNumber = inputView.getWinNumber();
		String bonusNumber = inputView.getBonusNumber();
		outputView.printWinnersStatistics(winNumber, myLottos, bonusNumber);
	}
}
