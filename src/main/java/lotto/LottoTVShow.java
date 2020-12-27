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
	private LottoBuyCount lottoTotalBuyCount;

	private LottoBuyCount manualLottoCount;

	private LottoBuyCount autoLottoCount;

	private Lotto lotto = new Lotto();

	private LottoPrizeAnalysisResult lottoPrizeAnalysisResult = new LottoPrizeAnalysisResult();

	private static final Money LOTTO_PRICE_PER_SHEET = new Money(1000);

	public void start() {
		LottoList lottoList = processUserInput();
		lottoList = lotto.generateAutoLotto(this.autoLottoCount, lottoList);
		InputView.printPurchaseLottoNumber(lottoList);
		LottoMatchResultList lottoMatchResultList = processLotto(lottoList);
		this.lottoPrizeAnalysisResult.arrangePrize(lottoMatchResultList, LOTTO_PRICE_PER_SHEET);
		ResultView.printResult(lottoMatchResultList, lottoPrizeAnalysisResult);
	}

	private LottoList processUserInput() {
		this.lottoTotalBuyCount = printAutoLottoNotice();
		this.manualLottoCount = printManualLottoNotice();
		this.autoLottoCount = lottoTotalBuyCount.getAutoLottoCount(this.manualLottoCount);
		InputView.printPurchaseLottoCount(this.autoLottoCount, this.manualLottoCount);
		LottoList lottoList = printInputManualLotto(this.manualLottoCount);
		return lottoList;
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

	public LottoMatchResultList compareLastWeekPrizeNumberWithPurchasedLottoNumber(Lotto lastWeekPrizeNumbers, LottoList purchasedLottos, LottoNumber bonusNumber) {
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
