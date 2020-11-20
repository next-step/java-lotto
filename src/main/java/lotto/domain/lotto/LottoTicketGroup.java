package lotto.domain.lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketGroup {
    public static LottoTicketGroup EMPTY = LottoTicketGroup.of(Collections.emptyList());
    private final List<LottoTicket> lottoTickets;

    private LottoTicketGroup(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTicketGroup of(final List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            return EMPTY;
        }
        return new LottoTicketGroup(lottoTickets);
    }

    public static LottoTicketGroup combine(final LottoTicketGroup... lottoTicketGroups) {
        if (lottoTicketGroups == null) {
            return EMPTY;
        }
        final List<LottoTicket> lottoTickets = Arrays.stream(lottoTicketGroups)
                .map(LottoTicketGroup::get)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return of(lottoTickets);
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
