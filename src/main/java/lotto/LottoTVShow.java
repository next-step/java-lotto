package lotto;

import lotto.domain.*;
import lotto.domain.input.LottoBuyCount;
import lotto.domain.input.Money;
import lotto.domain.result.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoTVShow {

	public static final Money LOTTO_PRICE_PER_SHEET = new Money(1000);

	public void start() {
		Money purchaseAmount = InputView.printInputNoticeForPurchaseAmount();
		int manualLottoCount = InputView.printInputManualLottoCount();
		LottoBuyCount lottoBuyCount = new LottoBuyCount(purchaseAmount, manualLottoCount);
		InputView.printPurchaseLottoCount(manualLottoCount, lottoBuyCount.getAutoLottoCount());

		List<Lotto> manualLottos = InputView.printInputManualLotto(manualLottoCount);

		LottoList lottoList = new LottoList(manualLottos, lottoBuyCount.getAutoLottoCount());
		InputView.printPurchaseLottoNumber(lottoList);

		Lotto lastWeekPrizeNumbers = InputView.printLastPrizeInput();
		LottoNumber bonusNumber = InputView.printBonusNumberInput();

		LottoMatchResultList lottoMatchResultList = new LottoMatchResultList(lastWeekPrizeNumbers, lottoList, bonusNumber);
		LottoPrizeAnalysisResult lottoPrizeAnalysisResult = new LottoPrizeAnalysisResult(lottoMatchResultList);
		ResultView.printResult(lottoMatchResultList, lottoPrizeAnalysisResult);
	}

}
