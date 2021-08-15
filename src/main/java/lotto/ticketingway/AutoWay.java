package lotto.ticketingway;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.AllPossibleLottoNumbers;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketMachine.OrderInput;
import lotto.domain.TicketCount;

public class AutoWay implements LottoTicketingWay {

    @Override
    public List<LottoTicket> issueLottoTickets(OrderInput input) {
        TicketCount ticketCount = input.getAutoTicketCount();

        List<LottoTicket> tickets = new ArrayList<>();

        AllPossibleLottoNumbers allPossibleNumbers = AllPossibleLottoNumbers.getInstance();

        for (int i = 0; i < ticketCount.value(); i++) {
            List<LottoNumber> sixLottoNumbers = allPossibleNumbers.drawRandomSixNumbers();
            tickets.add(LottoTicket.generateByLottoNumbers(sixLottoNumbers));
        }

        return tickets;
    }

}
