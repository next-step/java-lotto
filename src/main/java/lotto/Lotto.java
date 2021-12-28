package lotto;

import java.util.List;

import lotto.controller.LottoController;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.view.ResultView;

public class Lotto {
	public static void main(String[] args) {
		LottoController controller = new LottoController();
		LottoStore lottoStore = controller.readyToBuyLotto();
		List<LottoNumbers> lottoNumbers = controller.buyLotto(lottoStore);
		ResultView.printHead(lottoStore);
		ResultView.printPurchasedLotto(lottoNumbers);
		LottoNumbers winningNumbers = controller.inputWinnings();
		LottoNumber bonusNumber = controller.inputBonusNumber();
		LottoResult lottoResult = controller.calculatedResult(winningNumbers, bonusNumber, lottoNumbers);
		ResultView.printLottoResult(lottoResult);

	}
}
