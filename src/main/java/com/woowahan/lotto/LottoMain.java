package com.woowahan.lotto;

import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.Lottos;
import com.woowahan.lotto.model.PurchaseInput;
import com.woowahan.lotto.model.WinNumbers;
import com.woowahan.lotto.view.InputView;
import com.woowahan.lotto.view.LottoReport;
import com.woowahan.lotto.view.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		PurchaseInput purchaseInput = PurchaseInput.of(InputView.getPurchaseAmount(), InputView.getManualNumbers());
		Lottos lottos = Lottos.purchase(purchaseInput);
		ResultView.printResult(LottoReport.reportLottos(lottos.getLottos()));
		WinNumbers winNumbers = WinNumbers.of(InputView.getWinNumber(), InputView.getBonusNumber());
		LottoResult result = LottoResult.analyze(winNumbers, lottos.getLottos());
		ResultView.printResult(LottoReport.reportLottoResult(result));
	}
}
