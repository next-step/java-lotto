package lotto;

import java.util.List;

import lotto.domain.BenefitResult;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.RankSituation;
import lotto.domain.WinningLotto;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		long purchaseAmount = InputView.inputPurchaseAmount();
		long manalCount = InputView.inputManualCount();
		LottoMachine lottoMachine = new LottoMachine(purchaseAmount, InputView.inputManualLottos(manalCount));

		ResultView.printPurchasedCount(manalCount, lottoMachine.getAutoCount());
		ResultView.printCurrentSituation(lottoMachine.getPurchasedLottos());

		String inputWinNumbers = InputView.inputWinNumbers();
		LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());
		WinningLotto winningLotto = new WinningLotto(inputWinNumbers, bonusNumber);
		winningLotto.calculateScore(lottoMachine.getPurchasedLottos());

		List<RankSituation> rankSituations = lottoMachine.makeRankSituations();
		ResultView.printRankSituations(lottoMachine.sortInOrderScore(rankSituations));

		BenefitResult benefitResult = new BenefitResult(rankSituations, purchaseAmount);
		ResultView.printTotalProfitRate(benefitResult);
	}
}
