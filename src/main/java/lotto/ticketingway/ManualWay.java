package lotto.ticketingway;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine.OrderInput;

public class ManualWay implements LottoTicketingWay {

    @Override
    public List<LottoTicket> issueLottoTickets(OrderInput input) {
        int[][] manualLottoNumbers = input.getManualLottoNumbers();

        List<LottoTicket> tickets = new ArrayList<>();

        for (int[] inputNumbers : manualLottoNumbers) {
            tickets.add(LottoTicket.generateByIntegerArray(inputNumbers));
        }

        return tickets;
    }
}
