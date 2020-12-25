package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMatchResult;
import lotto.domain.LottoResult;
import lotto.model.LottoPrizePolicy;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoTVShow {
	private Lotto lotto = new Lotto();
	private LottoResult lottoResult = new LottoResult();

	private static final int LOTTO_PRICE_PER_SHEET = 1000;

	public void start() {
		int lottoTryCount = printIntro();
		InputView.printPurchaseLottoCount(lottoTryCount);
		List<Lotto> purchasedLottos = lotto.generatePurchagedAutoLotto(lottoTryCount);
		InputView.printPurchaseLottoNumber(purchasedLottos);

		List<LottoMatchResult> lottoMatchResultList = processLotto(purchasedLottos);

		this.lottoResult.arrangePrize(lottoMatchResultList, LOTTO_PRICE_PER_SHEET);
		ResultView.printResult(lottoMatchResultList, lottoResult);
	}

	private int printIntro() {
		int purchaseAmount = InputView.printInputNoticeForPurchaseAmount();
		return calculateLottoCount(purchaseAmount);
	}

	private List<LottoMatchResult> processLotto(List<Lotto> purchasedLottos) {
		Lotto lastWeekPrizeNumbers = InputView.printLastPrizeInput();
		int bonusNumber = InputView.printBonusNumberInput();
		return this.compareLastWeekPrizeNumberWithPurchasedLottoNumber(lastWeekPrizeNumbers, purchasedLottos, bonusNumber);
	}

	public List<LottoMatchResult> compareLastWeekPrizeNumberWithPurchasedLottoNumber(Lotto lastWeekPrizeNumbers, List<Lotto> buyLottos, int bonusNumber) {
		List<LottoMatchResult> lottoResultList = new ArrayList<>();
		for (Lotto lotto : buyLottos) {
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
