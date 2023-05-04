package lotto;


import lotto.domain.LottoTickets;
import lotto.domain.strategy.LottoTicketsAutoCreateStrategy;
import lotto.domain.strategy.LottoTicketsManualCreateStrategy;
import lotto.dto.CheckWinningRequest;
import lotto.dto.LottoTicketBuyRequest;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoTicketBuyRequest request = inputView.buyLotto();
        LottoTickets lottoTickets = LottoTickets.of(new LottoTicketsAutoCreateStrategy(request.getBuyAutomaticCount()));
        lottoTickets.addTickets(LottoTickets.of(new LottoTicketsManualCreateStrategy(request.getManualNumbers())));
        resultView.printLottoTickets(lottoTickets);
        CheckWinningRequest checkWinningRequest = inputView.checkWinning();
        resultView.printWiningResult(lottoTickets.tallyUp(checkWinningRequest.toWin()));
    }
}
