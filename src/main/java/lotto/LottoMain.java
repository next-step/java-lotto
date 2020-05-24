package lotto;

import lotto.service.LottoService;
import lotto.domain.LottoTicket;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int inputMoney = InputView.inputMoney();

        LottoService lottoService = LottoService.getInstance();
        List<LottoTicket> lottoTicketList = lottoService.purchaseLottoTicket(inputMoney);

        ResultView resultView = new ResultView(lottoTicketList);
        resultView.printLottoTicketList();

        String winningNumbers = InputView.inputWinningNumbers();
        resultView.printMatchResult(winningNumbers);
    }
}
