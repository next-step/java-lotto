package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoTickets;
import lotto.domain.dto.ResultDto;
import lotto.domain.dto.WinningNumberDto;
import lotto.domain.dto.WinningLottoTicketDto;
import lotto.view.LottoTicketCountView;
import lotto.view.LottoTicketPrintView;
import lotto.view.WinnerNumberView;
import lotto.view.WinningResultView;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();

        int money = LottoTicketCountView.getLottoTicketCount();
        LottoTickets lottoTickets = lottoController.autoBuyLottoTickets(money);

        LottoTicketPrintView.printLottoTickets(lottoTickets);
        WinningNumberDto winnerNumber = WinnerNumberView.getWinningNumberDto();

        ResultDto dto = lottoController.lottoResult(new WinningLottoTicketDto(lottoTickets, winnerNumber));
        WinningResultView.resultView(dto);
    }

}
