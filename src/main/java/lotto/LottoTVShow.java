package lotto;

import lotto.domain.*;
import lotto.domain.input.LottoBuyCount;
import lotto.domain.input.Money;
import lotto.domain.result.*;
import lotto.model.LottoPrizePolicy;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.view.InputView.printInputManualLotto;

public class LottoTVShow {
	private Lotto lotto = new Lotto();

	private LottoPrizeAnalysisResult lottoPrizeAnalysisResult = new LottoPrizeAnalysisResult();

	private static final Money LOTTO_PRICE_PER_SHEET = new Money(1000);

	public void start() {
		LottoBuyCount lottoTotalBuyCount = printAutoLottoNotice();
		LottoBuyCount manualLottoCount = printManualLottoNotice();
		LottoBuyCount autoLottoCount = lottoTotalBuyCount.getAutoLottoCount(manualLottoCount);
		LottoList lottoList = printInputManualLotto(manualLottoCount);
		InputView.printPurchaseLottoCount(autoLottoCount, manualLottoCount);

		lottoList = lotto.generateAutoLotto(autoLottoCount, lottoList);
		InputView.printPurchaseLottoNumber(lottoList);

		LottoMatchResultList lottoMatchResultList = processLotto(lottoList);

		this.lottoPrizeAnalysisResult.arrangePrize(lottoMatchResultList, LOTTO_PRICE_PER_SHEET);
		ResultView.printResult(lottoMatchResultList, lottoPrizeAnalysisResult);
	}

	private LottoBuyCount printManualLottoNotice() {
		LottoBuyCount manualLottoCount = InputView.printInputManualLottoCount();
		return manualLottoCount;
	}

	private LottoBuyCount printAutoLottoNotice() {
		Money purchaseAmount = InputView.printInputNoticeForPurchaseAmount();
		return calculateLottoCount(purchaseAmount);
	}

	private LottoMatchResultList processLotto(LottoList purchasedLottos) {
		Lotto lastWeekPrizeNumbers = InputView.printLastPrizeInput();
		LottoNumber bonusNumber = InputView.printBonusNumberInput();
		return this.compareLastWeekPrizeNumberWithPurchasedLottoNumber(lastWeekPrizeNumbers, purchasedLottos, bonusNumber);
	}

	public LottoMatchResultList compareLastWeekPrizeNumberWithPurchasedLottoNumber(Lotto lastWeekPrizeNumbers,LottoList purchasedLottos, LottoNumber bonusNumber) {
		LottoMatchResultList lottoResultList = new LottoMatchResultList();
		for (Lotto lotto : purchasedLottos.getLottoList()) {
			HasBonusNumber isMatchBonus = LottoPrizePolicy.isMatchBonusNumber(lotto, bonusNumber);
			MatchCount matchCount = lastWeekPrizeNumbers.countMatchNumber(lotto);
			MatchResultPerLotto matchResultPerLotto = new MatchResultPerLotto(matchCount, isMatchBonus);
			lottoResultList.add(matchResultPerLotto);
		}
		return lottoResultList;
	}

	public LottoBuyCount calculateLottoCount(Money purchaseAmount) {
		return purchaseAmount.calculateLottoCount(LOTTO_PRICE_PER_SHEET);
	}
}
