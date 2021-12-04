package step2;

import step2.domain.LottoTickets;
import step2.dto.Ticket;
import step2.dto.WinningResult;
import step2.service.LottoGameService;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Map;

public class LottoGameMain {
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();

    public static void main(String[] args) {
        Ticket ticket = INPUT_VIEW.inputBuyLotto();

        LottoGameService lottoGameService = new LottoGameService();

        LottoTickets lottoTickets = lottoGameService.shuffleLotto(ticket);
        RESULT_VIEW.renderLottoStatus(lottoTickets.lottoTickets());

        WinningResult winningResult = lottoTickets.matchedWinningNumber(INPUT_VIEW.pickWinningNumber());
        RESULT_VIEW.renderWinningResult(ticket, winningResult.getResults());
    }
}
