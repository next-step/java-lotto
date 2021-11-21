package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.AutoLottoNumberUtils;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(Integer size) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottoTickets.add(LottoTicket.from(AutoLottoNumberUtils.getAutoLottoNumber()));
        }
        return new LottoTickets(lottoTickets);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
