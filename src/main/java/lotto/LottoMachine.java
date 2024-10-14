package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {
    private List<Integer> lottoNumberRange;
    private List<Lotto> totalLottoTicket;

    public LottoMachine() {
        totalLottoTicket = new ArrayList<>();
    }

    public Lotto makeLottoTicket() {
        return new Lotto();
    }

    public List<Lotto> makeTotalLottoTickets(int totalTicketCount) {
        IntStream.range(0, totalTicketCount)
             .mapToObj(i -> makeLottoTicket())
             .forEach(totalLottoTicket::add);
        return totalLottoTicket;
    }


}
