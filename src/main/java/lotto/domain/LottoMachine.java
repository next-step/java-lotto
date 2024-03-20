package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final int number;
    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int number) {
        this.number = number;
        this.lottoTickets = new ArrayList<>();
    }

    public void makeLottos() {
        for (int i = 0; i < number; i++) {
            lottoTickets.add(new LottoTicket());
            lottoTickets.get(i).generate();
        }
    }

    public int showNumberOfLottos() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
