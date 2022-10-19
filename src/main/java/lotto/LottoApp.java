package lotto;

import lotto.core.LottoJudge;
import lotto.core.Lottos;
import lotto.core.TicketPriceInput;
import lotto.core.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApp {

    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start(){
        TicketPriceInput ticketPriceInput = inputView.getTicketPriceInput();
        Lottos lottos = new Lottos(ticketPriceInput.getTicketAmt());
        resultView.printLottos(lottos);
        WinningNumbers winningNumbersInput = inputView.getWinningNumbers();
        LottoJudge lottoJudge = new LottoJudge();
        lottoJudge.judge(lottos, winningNumbersInput);
        resultView.printResult(lottoJudge.getWinnerCount(), lottoJudge.getProfitRatio());
    }
}
