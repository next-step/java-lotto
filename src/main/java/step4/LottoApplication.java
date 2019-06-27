package step4;

import step4.domain.LottoSeller;
import step4.domain.LottoTicket;
import step4.domain.ResultSheet;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        final int inputMoney = InputView.askMoneyToInput();
        final int numberOfTicketsToBuy = LottoSeller.countLottoTickets(inputMoney);

        OutputView.printNumberOfTickets(numberOfTicketsToBuy);

        List<LottoTicket> lottoTickets = LottoSeller.issueLottoTicket(numberOfTicketsToBuy);
        OutputView.printLottoTickets(lottoTickets);

        LottoTicket luckyNumber = LottoSeller.getLuckyNumber(InputView.askLuckyNumber());
        int bonusNumber = InputView.askBonusNumber();

        ResultSheet result = ResultSheet.getResult(lottoTickets, luckyNumber, bonusNumber);
        OutputView.printResult(result);
    }
}

