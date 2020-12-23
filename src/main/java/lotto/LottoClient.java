package lotto;

import lotto.application.LottoService;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.domain.WinLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoClient {
	public static void main(String[] args) {
		Money money = new Money(InputView.waitInputMoney());

		LottoService lottoService = new LottoService(money);

		OutputView.printLottoLotteries(lottoService.getLottoLotteries());

		WinLottoNumbers winLottoNumbers = new WinLottoNumbers(InputView.waitInputLastWinNumbers());
		LottoResults lottoResults = lottoService.getLottoResults(winLottoNumbers);

		OutputView.printLottoResults(lottoResults);
	}
}
