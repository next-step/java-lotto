package lotto;

import java.util.List;

import lotto.domain.BenefitResult;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.ManualLottos;
import lotto.domain.RankSituation;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		long purchaseAmount = InputView.inputPurchaseAmount();
		long manalCount = InputView.inputManualCount();

		ManualLottos manualLottos = new ManualLottos(InputView.inputManualLottos(manalCount));
		LottoMachine lottoMachine = new LottoMachine(purchaseAmount, manualLottos);

		ResultView.printPurchasedCount(manualLottos.size(), lottoMachine.getAutoCount());
		ResultView.printCurrentSituation(lottoMachine.getPurchasedLottos());

		WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinNumbers());
		LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());

		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
		winningLotto.calculateScore(lottoMachine.getPurchasedLottos());

		List<RankSituation> rankSituations = lottoMachine.makeRankSituations();
		ResultView.printRankSituations(lottoMachine.sortInOrderScore(rankSituations));

		BenefitResult benefitResult = new BenefitResult(rankSituations, purchaseAmount);
		ResultView.printTotalProfitRate(benefitResult);
	}
}
