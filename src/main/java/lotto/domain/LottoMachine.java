package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final int number;
    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int number) {
        this.number = number;
        this.lottoTickets = generateLottoTickets();
    }

    public List<LottoTicket> generateLottoTickets() {
        for (int i = 0; i < number; i++) {
            lottoTickets.add(new LottoTicket());
            lottoTickets.get(i).generate();
        }
        return Collections.unmodifiableList(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
