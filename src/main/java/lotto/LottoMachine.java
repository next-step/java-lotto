package lotto;

import lotto.domain.Calculator;
import lotto.domain.Generator;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoMachine {

    private final ConsoleView consoleView;

    public LottoMachine(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public List<LottoTicket> buyLotto() {
        int lottoTicketCount = Calculator.calculateLottoTicketCount(consoleView.getPayment());
        int manualLottoCount = consoleView.getManualLottoCount();
        int autoLottoTicketCount = Calculator.getAutoLottoCount(lottoTicketCount, manualLottoCount);

        List<List<Integer>> manualLottoNumbers = consoleView.getManualLottoNumbers(manualLottoCount);
        List<LottoTicket> manualLottoTickets = Generator.generateManualLottoTicket(manualLottoNumbers);

        consoleView.printTickets(manualLottoCount, autoLottoTicketCount);
        List<LottoTicket> autoLottoTickets = Generator.generateLottoTickets(autoLottoTicketCount);
        autoLottoTickets.addAll(manualLottoTickets);
        consoleView.printLottoTickets(autoLottoTickets);

        return autoLottoTickets;
    }
}
