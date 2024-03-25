package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final int number;
    private final LottoTickets lottoTickets;

    public LottoMachine(int number) {
        this(number, new ArrayList<>());
    }

    public LottoMachine(int number, List<LottoTicket> lottoTickets) {
        this(number, new LottoTickets(lottoTickets));
    }

    public LottoMachine(int number, LottoTickets lottoTickets) {
        this.number = number;
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> generateLottoTickets() {
        return lottoTickets.generateLottoTickets(number);
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

}
