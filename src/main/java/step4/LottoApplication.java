package step4;

import step4.domain.*;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        final int inputMoney = InputView.askMoneyToInput();
        final int numberOfManualTickets = InputView.askNumberOfManualTicket();
//        final int numberOfTicketsToBuy = LottoSeller.countLottoTickets(inputMoney);

        OutputView.printNumberOfTickets(numberOfTicketsToBuy);

        LottoTickets lottoTickets = LottoSeller.issueLottoTicket(numberOfTicketsToBuy);
        OutputView.printLottoTickets(lottoTickets);

        LuckyTicket luckyTicket = LottoSeller
                .getLuckyNumber(InputView.askLuckyNumber(), InputView.askBonusNumber());

        ResultSheet result = ResultSheet.getResult(lottoTickets, luckyTicket);
        OutputView.printResult(result);
    }
}

