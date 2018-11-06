package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoConsole {

	public static void main(String[] args) {
		int money = InputView.buyLotto();

		LottoMachine lottoMachine = new LottoMachine(money);
		LottoTicket lottoTicket = lottoMachine.getLottos();
		ResultView.printBuyingLottos(lottoTicket);

		String winningNumbers = InputView.drawWinningNumbers();

		WinningNumber winningNumber = new WinningNumber(winningNumbers);
		WinningResult winningResult = lottoTicket.win(winningNumber);
		ResultView.printResult(winningResult);
	}
}
