package lotto;

import lotto.service.LottoService;
import lotto.domain.LottoTicket;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        List<LottoTicket> lottoTicketList = lottoService.purchaseLottoTicket(InputView.inputMoney());

        ResultView resultView = new ResultView();
        resultView.printLottoTicketList(lottoTicketList);

        String winningNumbers = InputView.inputWinningNumbers();
        LottoTicket lottoTicket = lottoService.matchLottoTicket(lottoTicketList, winningNumbers);
        resultView.printMatchResult(lottoTicket);
    }
}
