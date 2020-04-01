package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoChecker;
import lotto.domain.LottoMoney;
import lotto.dto.LottoNumberDto;
import lotto.dto.PurchasedLottoNumbersDto;
import lotto.ui.InputView;
import lotto.ui.OutputView;

import java.util.List;

public class Lotto {

	public void start() {
		InputView inputView = InputView.getInstance();
		OutputView outputView = OutputView.getInstance();

		LottoBuyer lottoBuyer = new LottoBuyer();
		LottoMoney money = new LottoMoney(inputView.getSpentMoney());
		List<LottoNumberDto> passiveNumbers = inputView.getPassiveLottoNumbers();
		PurchasedLottoNumbersDto numbers = lottoBuyer.buyLottoNumbers(money, passiveNumbers);
		outputView.printLottoNumbers(numbers);

		LottoNumberDto wonNumber = inputView.getWonLastWeekLottoNumbers();
		int wonBonusNumber = inputView.getWonLastWeekBonusNumber();
		LottoChecker lottoChecker = new LottoChecker(wonNumber, wonBonusNumber, money);

		outputView.printStatistics(lottoChecker.getWinningResult(numbers.getLottoNumbers()));
	}

	public static void main(String[] args) {
		new Lotto().start();
	}
}
