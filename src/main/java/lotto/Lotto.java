package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoChecker;
import lotto.dto.LottoNumbers;
import lotto.dto.PurchasedLottoNumbers;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.Collections;
import java.util.List;

public class Lotto {

	public void start() {
		InputView inputView = InputView.getInstance();
		OutputView outputView = OutputView.getInstance();

		LottoBuyer lottoBuyer = new LottoBuyer();
		long spentMoney = inputView.getSpentMoney();
		List<LottoNumbers> passiveNumbers = inputView.getPassiveLottoNumbers();
		PurchasedLottoNumbers numbers = lottoBuyer.buyLottoNumbers(spentMoney, passiveNumbers);
		outputView.printLottoNumbers(numbers);

		LottoNumbers wonNumber = inputView.getWonLastWeekLottoNumbers();
		int wonBonusNumber = inputView.getWonLastWeekBonusNumber();
		LottoChecker lottoChecker = new LottoChecker(wonNumber, wonBonusNumber, spentMoney);

		outputView.printStatistics(lottoChecker.getWinningResult(numbers.getLottoNumbers()));
	}

	public static void main(String[] args) {
		new Lotto().start();
	}
}
