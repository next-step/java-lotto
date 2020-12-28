package lotto;

import lotto.application.LottoService;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoClient {
	public static void main(String[] args) {
		Money money = InputView.waitInputMoney();

		LottoService lottoService = new LottoService(money, new RandomLottoNumberGenerator());

		OutputView.printLottoLotteries(lottoService.getLottoLotteries());

		WinLottoNumbers winLottoNumbers = InputView.waitInputWinLottoNumbers();
		LottoResults lottoResults = lottoService.getLottoResults(winLottoNumbers);

		OutputView.printLottoResults(lottoResults);
	}
}
