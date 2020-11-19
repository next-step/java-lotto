package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    public static LottoTickets EMPTY = LottoTickets.of(Collections.emptyList());
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets of(final List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            return EMPTY;
        }
        return new LottoTickets(lottoTickets);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> get() {
        return lottoTickets;
    }

    public List<List<Integer>> getAllLottoNumber() {
        return lottoTickets.stream().map(LottoTicket::getLottoNumber).collect(Collectors.toList());
    }
}
