package lotto;

import lotto.domain.Calculator;
import lotto.domain.Generator;
import lotto.domain.LottoTicket;

import java.util.List;

public class LottoMachine {

    public int buyLotto(int payment, int manualLottoCount) {
        int lottoTicketCount = Calculator.calculateLottoTicketCount(payment);
        return Calculator.getAutoLottoCount(lottoTicketCount, manualLottoCount);
    }

    public List<LottoTicket> getLotto(int autoLottoTicketCount, List<List<Integer>> manualLottoNumbers) {
        List<LottoTicket> manualLottoTickets = Generator.generateManualLottoTicket(manualLottoNumbers);
        List<LottoTicket> autoLottoTickets = Generator.generateLottoTickets(autoLottoTicketCount);
        autoLottoTickets.addAll(manualLottoTickets);
        return autoLottoTickets;
    }
}
