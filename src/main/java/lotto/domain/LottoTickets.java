package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(int gameCount) {
        this.lottoTickets = new ArrayList<>();
        this.lottoTickets = purchasedLottoTicket(gameCount);
    }

    public List<LottoTicket> purchasedLottoTicket(int gameCount) {
        for (int i = 0; i < gameCount; i++) {
            lottoTickets.add(new LottoTicket(new LottoNumbers()));
        }
        return lottoTickets;
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public long count() {
        return lottoTickets.stream()
                .count();
    }

}
