package lotto;

import lotto.domain.LottoBuyer;
import lotto.domain.LottoChecker;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.dto.LottoNumberDto;
import lotto.dto.PurchasedLottoNumbersDto;
import lotto.ui.InputView;
import lotto.ui.LottoTickets;
import lotto.ui.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

	public static void main(String[] args) {
		new Lotto().start();
	}

	public void start() {
		InputView inputView = InputView.getInstance();
		OutputView outputView = OutputView.getInstance();

		LottoMoney money = new LottoMoney(inputView.getSpentMoney());
		LottoTickets passiveNumbers = inputView.getPassiveLottoNumbers();

		LottoBuyer lottoBuyer = new LottoBuyer(getLottoNumberList(passiveNumbers));
		PurchasedLottoNumbersDto numbers = lottoBuyer.buyLottoNumbers(money);
		outputView.printLottoNumbers(numbers);

		LottoNumberDto wonNumber = inputView.getWonLastWeekLottoNumbers();
		int wonBonusNumber = inputView.getWonLastWeekBonusNumber();
		LottoChecker lottoChecker = new LottoChecker(wonNumber, wonBonusNumber, money);

		outputView.printStatistics(lottoChecker.getWinningResult(numbers.getLottoNumbers()));
	}

	private List<LottoNumber> getLottoNumberList(LottoTickets lottoTickets) {
		return lottoTickets.getLottoTickets()
				.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList());
	}
}
