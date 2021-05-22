package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoTickets implements Iterable<LottoTicket> {

    private final List<LottoTicket> lottoTickets;

    public static LottoTickets autoTickets(int count) {
        validateCount(count);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(LottoTicket.autoTicket());
        }
        return new LottoTickets(lottoTickets);
    }

    private static void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("구매 수량을 입력해 주세요.");
        }
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public Iterator<LottoTicket> iterator() {
        return lottoTickets.iterator();
    }
}
