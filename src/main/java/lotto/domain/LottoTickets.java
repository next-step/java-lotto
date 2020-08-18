package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public List<LottoTicket> purchasedLottoTicket(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            lottoTickets.add(new LottoTicket(new LottoNumbers()));
        }
        return lottoTickets;
    }

    public long count() {
        return lottoTickets.stream()
                .count();
    }

}
