package lotto;

import java.util.List;

import lotto.application.LottoService;
import lotto.domain.LottoCount;
import lotto.domain.LottoLotteries;
import lotto.domain.LottoLottery;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoClient {
	public static void main(String[] args) {
		Money money = InputView.waitInputMoney();
		int manualCount = InputView.waitInputManualLottoLotteryCount();
		List<LottoLottery> manualLottoLotteries = InputView.waitInputManualLottoNumbers(manualCount);

		LottoCount lottoCount = new LottoCount(money, manualCount);
		LottoService lottoService = new LottoService(new RandomLottoNumberGenerator());
		LottoLotteries lottoLotteries = lottoService.buyLottoLotteries(manualLottoLotteries, lottoCount.getAutoCount());

		OutputView.printLottoCounts(lottoCount);
		OutputView.printLottoLotteries(lottoLotteries);

		WinLottoNumbers winLottoNumbers = InputView.waitInputWinLottoNumbers();
		LottoResults lottoResults = lottoService.checkLottoResults(lottoLotteries, winLottoNumbers);

		OutputView.printLottoResults(lottoResults);
	}
}
