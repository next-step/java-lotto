package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final LottoTickets lottoTickets;

    public LottoMachine() {
        this(new ArrayList<>());
    }

    public LottoMachine(List<LottoTicket> lottoTickets) {
        this(new LottoTickets(lottoTickets));
    }

    public LottoMachine(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> generateLottoTickets(int number) {
        return lottoTickets.generateLottoTickets(number);
    }

    public void addLottoTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

}
