package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.ManualPickLottoGenerator;
import lotto.domain.QuickPickLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.dto.PurchaseInfo;
import lotto.dto.WinningNumber;
import lotto.utils.WinningLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoConsole {

	public static void main(String[] args) {
		PurchaseInfo purchaseInfo = InputView.buyLotto();

		LottoMachine manualPickLottoMachine = new LottoMachine(new ManualPickLottoGenerator());
		LottoTicket manualLottoTicket = manualPickLottoMachine.purchase(purchaseInfo);
		LottoMachine quickPickLottoMachine = new LottoMachine(new QuickPickLottoGenerator());
		LottoTicket quickPickLottoTicket = quickPickLottoMachine.purchase(purchaseInfo);
		ResultView.printBuyingLottos(manualLottoTicket, quickPickLottoTicket);

		WinningNumber winningNumber = InputView.drawWinningNumbers();
		WinningLotto winningLotto = WinningLottoGenerator.generate(winningNumber);

		WinningResult manualPickResult = manualLottoTicket.match(winningLotto);
		WinningResult quickPickResult= quickPickLottoTicket.match(winningLotto);
		ResultView.printResult(purchaseInfo.getMoney(), quickPickResult.join(manualPickResult));
	}
}
