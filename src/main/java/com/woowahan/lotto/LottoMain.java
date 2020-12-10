package com.woowahan.lotto;

import com.woowahan.lotto.model.LottoResult;
import com.woowahan.lotto.model.Lottos;
import com.woowahan.lotto.model.PurchaseInput;
import com.woowahan.lotto.model.WinNumberInput;
import com.woowahan.lotto.view.InputView;
import com.woowahan.lotto.view.LottoReport;
import com.woowahan.lotto.view.ResultView;

public class LottoMain {

	public static void main(String[] args) {
		PurchaseInput purchaseInput = PurchaseInput.of(InputView.getPurchaseAmount());
		Lottos lottos = Lottos.purchase(purchaseInput);
		ResultView.printResult(LottoReport.reportLottos(lottos));
		WinNumberInput winNumberInput = WinNumberInput.of(InputView.getWinNumber());
		LottoResult result = LottoResult.analyze(winNumberInput, lottos.getLottos());
		ResultView.printResult(LottoReport.reportLottoResult(result));
	}
}
