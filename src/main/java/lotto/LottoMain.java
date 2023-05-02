package lotto;

import java.util.List;

import lotto.domain.BenefitResult;
import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.ManualLottos;
import lotto.domain.RankSituation;
import lotto.domain.WinningLotto;
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

		String inputWinNumbers = InputView.inputWinNumbers();
		WinningLotto winningLotto = new WinningLotto(inputWinNumbers);
		LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber());

		winningLotto.calculateScore(lottoMachine.getPurchasedLottos(), bonusNumber);

		List<RankSituation> rankSituations = lottoMachine.makeRankSituations();
		ResultView.printRankSituations(lottoMachine.sortInOrderScore(rankSituations));

		BenefitResult benefitResult = new BenefitResult(rankSituations, purchaseAmount);
		ResultView.printTotalProfitRate(benefitResult);
	}
}
