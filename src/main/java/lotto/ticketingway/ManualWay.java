package lotto.ticketingway;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoPurchaseOrder;
import lotto.domain.LottoTicket;

public class ManualWay implements LottoTicketingWay {

    @Override
    public List<LottoTicket> issueLottoTickets(int lottoTicketCount, LottoPurchaseOrder order) {

        List<LottoTicket> tickets = new ArrayList<>();

        int[][] manualLottoNumbers = order.getManualLottoNumbers();

        for (int[] inputNumbers : manualLottoNumbers) {
            tickets.add(LottoTicket.generateByIntegerArray(inputNumbers));
        }

        return tickets;
    }
}
