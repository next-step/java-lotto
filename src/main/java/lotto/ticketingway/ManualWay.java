package lotto.ticketingway;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.IssueInput;

public class ManualWay implements LottoTicketingWay {

    @Override
    public List<LottoTicket> issueLottoTickets(IssueInput input) {
        int[][] manualLottoNumbers = input.getManualLottoNumbers();

        List<LottoTicket> tickets = new ArrayList<>();

        for (int[] inputNumbers : manualLottoNumbers) {
            tickets.add(LottoTicket.generateByIntegerArray(inputNumbers));
        }

        return tickets;
    }
}
