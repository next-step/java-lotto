package step3;

import step3.domain.LottoRank;
import step3.domain.LottoSeller;
import step3.domain.LottoTicket;
import step3.domain.ResultSheet;
import step3.view.InputView;
import step3.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) {
        final int inputMoney = InputView.askMoneyToInput();
        final int numberOfTicketsToBuy = LottoSeller.countLottoTickets(inputMoney);

        OutputView.printNumberOfTickets(numberOfTicketsToBuy);

        List<LottoTicket> lottoTickets = LottoSeller.issueLottoTicket(numberOfTicketsToBuy);
        OutputView.printLottoTickets(lottoTickets);

        LottoTicket luckyNumber = LottoSeller.getLuckyNumber(InputView.askLuckyNumber());
        ResultSheet result = ResultSheet.getResult(lottoTickets, luckyNumber);

        OutputView.printResult(result, numberOfTicketsToBuy);
    }
}

