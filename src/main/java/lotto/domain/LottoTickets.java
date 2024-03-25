package lotto.domain;

import lotto.domain.number_generator.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> generateLottoTickets(int number) {
        for (int i = 0; i < number; i++) {
            lottoTickets.add(new LottoTicket(new RandomNumberGenerator().generate()));
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
