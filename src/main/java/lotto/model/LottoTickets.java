package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("lotto tickets is null");
        }

        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public LottoResults checkAll(final WinningLottoTicket winningLottoTicket) {
        List<LottoResult> lottoResults = lottoTickets.stream()
                .map(winningLottoTicket::check)
                .collect(Collectors.toList());

        return LottoResults.create(lottoResults);
    }

    public int size() {
        return lottoTickets.size();
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }
}
