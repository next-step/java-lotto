package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MyLottos;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
	private final InputView inputView;
	private final OutputView outputView;

	public LottoManager(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		Integer pay = inputView.inputPay();
		int manuallyCount = inputView.inputNumberOfLottosToPurchaseManually();

		List<Lotto> lottoList = new ArrayList<>();
		for (int j = 0; j < manuallyCount; j++) {
			String lottoNumbers = inputView.inputManualLottoNumbers();
			Lotto manualLotto = Lotto.createManualLotto(lottoNumbers);
			lottoList.add(manualLotto);
		}
		MyLottos manuallyLottos = new MyLottos(lottoList);
		MyLottos myLottos = outputView.printBuyLottos(pay, manuallyLottos);
		String winNumber = inputView.getWinNumber();
		String bonusNumber = inputView.getBonusNumber();
		outputView.printWinnersStatistics(winNumber, myLottos, bonusNumber);
	}
}
