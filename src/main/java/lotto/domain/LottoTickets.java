package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(Money money, LottoNumbers lottoNumbers) {
        int size = money.countLotto();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoTickets.add(new LottoTicket(lottoNumbers));
        }
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }
}
