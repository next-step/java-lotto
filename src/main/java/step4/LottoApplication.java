package step4;

import step4.domain.*;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        final int inputMoney = InputView.askMoneyToInput();
        final int numberOfManualTickets = InputView.askNumberOfManualTicket();
        final int numberOfAutoTickets = LottoSeller.countAutoTickets(inputMoney, numberOfManualTickets);

        List<String> manualTickets = InputView.askNumbersForManualTickets(numberOfManualTickets);
        OutputView.printNumberOfTickets(numberOfManualTickets, numberOfAutoTickets);

        LottoTickets lottoTickets = LottoSeller.issueLottoTicket(manualTickets, numberOfAutoTickets);
        OutputView.printLottoTickets(lottoTickets);

        LuckyTicket luckyTicket = LottoSeller
                .getLuckyNumber(InputView.askLuckyNumber(), InputView.askBonusNumber());

        ResultSheet result = ResultSheet.getResult(lottoTickets, luckyTicket);
        OutputView.printResult(result);
    }
}

