package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoResult;
import lotto.model.LottoPrizePolicy;
import lotto.view.InputView;
import lotto.view.ResultView;

import static lotto.view.InputView.printInputManualLotto;

public class LottoTVShow {
	private Lotto lotto = new Lotto();
	private LottoResult lottoResult = new LottoResult();

	private static final int LOTTO_PRICE_PER_SHEET = 1000;

	public void start() {
		int lottoTryCount = printAutoLottoNotice();
		int manualLottoCount = printManualLottoNotice();
		int autoLottoCount = lottoTryCount - manualLottoCount;
		LottoList lottoList = printInputManualLotto(manualLottoCount);
		InputView.printPurchaseLottoCount(autoLottoCount, manualLottoCount);

		lottoList = lotto.generatePurchagedAutoLotto(autoLottoCount, lottoList);
		InputView.printPurchaseLottoNumber(lottoList);

		LottoMatchResultList lottoMatchResultList = processLotto(lottoList);

		this.lottoResult.arrangePrize(lottoMatchResultList, LOTTO_PRICE_PER_SHEET);
		ResultView.printResult(lottoMatchResultList, lottoResult);
	}

	private int printManualLottoNotice() {
		int manualLottoCount = InputView.printInputManualLottoCount();
		return manualLottoCount;
	}

	private int printAutoLottoNotice() {
		int purchaseAmount = InputView.printInputNoticeForPurchaseAmount();
		return calculateLottoCount(purchaseAmount);
	}

	private LottoMatchResultList processLotto(LottoList purchasedLottos) {
		Lotto lastWeekPrizeNumbers = InputView.printLastPrizeInput();
		int bonusNumber = InputView.printBonusNumberInput();
		return this.compareLastWeekPrizeNumberWithPurchasedLottoNumber(lastWeekPrizeNumbers, purchasedLottos, bonusNumber);
	}

	public LottoMatchResultList compareLastWeekPrizeNumberWithPurchasedLottoNumber(Lotto lastWeekPrizeNumbers,LottoList purchasedLottos, int bonusNumber) {
		LottoMatchResultList lottoResultList = new LottoMatchResultList();
		for (Lotto lotto : purchasedLottos.getLottosList()) {
			boolean isMatchBonus = LottoPrizePolicy.isMatchBonusNumber(lotto, bonusNumber);
			int matchCount = lastWeekPrizeNumbers.countMatchNumber(lotto);
			LottoMatchResult lottoMatchResult = new LottoMatchResult(matchCount, isMatchBonus);
			lottoResultList.add(lottoMatchResult);
		}
		return lottoResultList;
	}

	public int calculateLottoCount(int purchaseAmount) {
		return purchaseAmount / LOTTO_PRICE_PER_SHEET;
	}
}
