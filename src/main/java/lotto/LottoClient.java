package lotto;

import java.util.List;

import lotto.application.LottoService;
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
		int totalCount = money.buyMax(LottoLottery.LOTTO_PRICE_PER_PIECE);
		int manualCount = InputView.waitInputManualLottoLotteryCount();
		List<LottoLottery> manualLottoLotteries = InputView.waitInputManualLottoNumbers(manualCount);
		int autoCount = totalCount - manualCount;

		LottoService lottoService = new LottoService(new RandomLottoNumberGenerator());
		LottoLotteries lottoLotteries = lottoService.buyLottoLotteries(manualLottoLotteries, autoCount);

		OutputView.printLottoCounts(manualCount, autoCount);
		OutputView.printLottoLotteries(lottoLotteries);

		WinLottoNumbers winLottoNumbers = InputView.waitInputWinLottoNumbers();
		LottoResults lottoResults = lottoService.checkLottoResults(lottoLotteries, winLottoNumbers);

		OutputView.printLottoResults(lottoResults);
	}
}
