package lotto;

import lotto.domain.LottoTicketMachine;
import lotto.domain.LottoTickets;
import lotto.domain.strategy.LottoTicketAutoCreateStrategy;
import lotto.dto.CheckWinningRequest;
import lotto.dto.LottoTicketBuyRequest;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoTicketMachine lottoService = new LottoTicketMachine();
        LottoTicketBuyRequest request = inputView.buyLotto();
        LottoTickets lottoTickets = lottoService.createTickets(request.getLottoCount(), new LottoTicketAutoCreateStrategy());
        resultView.printLottoTickets(lottoTickets);
        CheckWinningRequest checkWinningRequest = inputView.checkWinning();
        resultView.printWiningResult(lottoTickets.tallyUp(checkWinningRequest.getWinningNumbers()));


    }
}
