package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Client {
	public static void main(String[] args) {
		InputView inputVIew = new InputView();
		ResultView resultView = new ResultView();

		LottoMachine lottoMachine = new LottoMachine(inputVIew.purchasingPrice());
		resultView.showBuyingCount(lottoMachine.getBuyingCount());

		LottoTicket lottoTicket = lottoMachine.publish();
		resultView.showPickNumbers(lottoTicket);

		Lotto lastWinningLotto = new Lotto(inputVIew.lastWeekNumbers());
		LottoResult lottoResult = lottoTicket.matchWinning(lastWinningLotto);
		resultView.showStatistics(lottoResult);

		double rateOfReturn = lottoResult.requestRateOfReturn(lottoMachine.getBuyingCount());
		resultView.showRateOfReturns(rateOfReturn);

		inputVIew.close();
	}
}
