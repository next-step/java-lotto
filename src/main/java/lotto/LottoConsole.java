package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.dto.WinningNumber;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoConsole {

	public static void main(String[] args) {
		int money = InputView.buyLotto();

		LottoMachine lottoMachine = new LottoMachine(money);
		LottoTicket lottoTicket = lottoMachine.getLottos();
		ResultView.printBuyingLottos(lottoTicket);

		WinningNumber winningNumber = InputView.drawWinningNumbers();
		WinningLotto winningLotto = lottoMachine.getWinningLotto(winningNumber);
		WinningResult winningResult = lottoTicket.match(winningLotto);
		ResultView.printResult(winningResult);
	}
}
