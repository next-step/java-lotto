package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine2 {

    private int ticketCount;

    public LottoMachine2(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public List<LottoTicket2> issueTickets() {
        return Stream.generate(this::issueTicket)
              .limit(ticketCount)
              .collect(Collectors.toList());
    }

    private LottoTicket2 issueTicket() {
        Set<LottoNumber> sixNumbers = LottoShuffleMachine.getSixNumbers();
        return new LottoTicket2(sixNumbers);
    }
}
