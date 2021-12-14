package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningNumbers;
import lotto.domain.LottoCalculate;
import lotto.view.ResultView;

public class Lotto {
	public static void main(String[] args) {
		LottoController controller = new LottoController();
		List<LottoNumbers> lottoNumbers = controller.buyLotto();
		ResultView.printPurchasedLotto(lottoNumbers);
		WinningNumbers winningNumbers = controller.inputWinnings();
		LottoCalculate result = controller.calculatedResult(winningNumbers, lottoNumbers);
		ResultView.printLottoResult(result);

	}
}
