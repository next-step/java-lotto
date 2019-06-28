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

        // 수동으로 구매할 번호 입력
        List<List<Integer>> manualTickets = InputView.askNumbersForManualTickets(numberOfManualTickets);

        OutputView.printNumberOfTickets(numberOfManualTickets, numberOfAutoTickets);

        LottoTickets lottoTickets = LottoSeller.issueLottoTicket(numberOfAutoTickets);
        OutputView.printLottoTickets(lottoTickets);

        LuckyTicket luckyTicket = LottoSeller
                .getLuckyNumber(InputView.askLuckyNumber(), InputView.askBonusNumber());

        ResultSheet result = ResultSheet.getResult(lottoTickets, luckyTicket);
        OutputView.printResult(result);
    }
}

