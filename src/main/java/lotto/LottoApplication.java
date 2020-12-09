package lotto;

import lotto.domain.LottoTicket;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        LottoMachine lottoMachine = new LottoMachine();

        int payment = consoleView.getPayment();
        int manualLottoCount = consoleView.getManualLottoCount();
        List<List<Integer>> manualLottoNumbers = consoleView.getManualLottoNumbers(manualLottoCount);

        int autoLottoTicketCount = lottoMachine.buyLotto(payment, manualLottoCount);
        consoleView.printTickets(manualLottoCount, autoLottoTicketCount);

        List<LottoTicket> lottoTickets = lottoMachine.getLotto(autoLottoTicketCount, manualLottoNumbers);
        consoleView.printLottoTickets(lottoTickets);

        LottoResultReader lottoResultReader = new LottoResultReader(consoleView);
        lottoResultReader.readResult(lottoTickets);
    }
}
