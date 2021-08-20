package lotto.ticketingway;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;

public class ManualWay implements LottoTicketingWay {

    private final int[][] manualLottoNumbers;

    public ManualWay(int[][] manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    @Override
    public List<LottoTicket> issueLottoTickets() {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int[] inputNumbers : manualLottoNumbers) {
            tickets.add(LottoTicket.generateByIntegerArray(inputNumbers));
        }

        return tickets;
    }
}
