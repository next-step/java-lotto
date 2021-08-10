package lotto.ticketingway;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.AllPossibleLottoNumbers;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.exception.NotEnoughTicketCountException;

public class AutoNumberGeneratingWay implements LottoTicketingWay {

    private static final int MIN_TICKET_COUNT = 1;

    @Override
    public List<LottoTicket> issueLottoTickets(int lottoTicketCount) {

        checkMinimumTicketCount(lottoTicketCount);

        List<LottoTicket> tickets = new ArrayList<>();

        AllPossibleLottoNumbers allPossibleNumbers = AllPossibleLottoNumbers.getInstance();

        for (int i = 0; i < lottoTicketCount; i++) {
            List<LottoNumber> sixLottoNumbers = allPossibleNumbers.drawRandomSixNumbers();
            tickets.add(LottoTicket.generateByLottoNumbers(sixLottoNumbers));
        }

        return tickets;
    }

    private void checkMinimumTicketCount(int lottoTicketCount) {
        if (lottoTicketCount < MIN_TICKET_COUNT) {
            throw new NotEnoughTicketCountException(String
                .format("발행할 티켓은 최소 %d장이상입니다. [입력한 티켓수:%d]", MIN_TICKET_COUNT, lottoTicketCount));
        }
    }
}
