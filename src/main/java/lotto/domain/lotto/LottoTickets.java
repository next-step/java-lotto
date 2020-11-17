package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    public static LottoTickets EMPTY = LottoTickets.of(Collections.emptyList());
    private final List<LottoTicket> lottoTicketList;

    private LottoTickets(final List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = Collections.unmodifiableList(lottoTicketList);
    }

    public static LottoTickets of(final List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            return EMPTY;
        }
        return new LottoTickets(lottoTickets);
    }

    public int size() {
        return lottoTicketList.size();
    }

    public List<LottoTicket> get() {
        return lottoTicketList;
    }

    public List<List<Integer>> getAllLottoNumber() {
        return lottoTicketList.stream().map(LottoTicket::getLottoNumber).collect(Collectors.toList());
    }
}
