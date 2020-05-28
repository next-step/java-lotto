package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets newInstance(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public List<List<Integer>> getNumberGroups() {
        return this.lottoTickets.stream()
                .map(LottoTicket::getNumbers)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return this.lottoTickets.size();
    }
}
