package lotto;

import lotto.service.LottoService;
import lotto.domain.LottoTicket;
import lotto.ui.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoService lottoService = LottoService.getInstance();
        List<LottoTicket> lottoTicketList = lottoService.purchaseLottoTicket();

        ResultView resultView = new ResultView(lottoTicketList);
        resultView.printResult();


    }
}
