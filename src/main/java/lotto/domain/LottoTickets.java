package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> generateLottoTickets(int number) {
        for (int i = 0; i < number; i++) {
            lottoTickets.add(new LottoTicket());
            List<Integer> generatedNumbers = lottoTickets.get(i).generate();
            lottoTickets.set(i, new LottoTicket(generatedNumbers));
        }
        return Collections.unmodifiableList(lottoTickets);
    }

    public void add(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
