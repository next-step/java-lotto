package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets() {
        lottoTickets = new ArrayList<>();
    }

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(final String... lottoTicketString) {
        this.lottoTickets = Arrays.stream(lottoTicketString)
                .map(ManualLottoGenerator::new)
                .map(ManualLottoGenerator::generate)
                .collect(Collectors.toList());
    }

    public void add(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoStatistic matchLottoTickets(final WinningLottoTicket winningLottoTicket) {
        List<LottoRank> lottoStatistic = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            lottoStatistic.add(lottoTicket.matchLottoRank(winningLottoTicket));
        }
        return new LottoStatistic(lottoStatistic);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}