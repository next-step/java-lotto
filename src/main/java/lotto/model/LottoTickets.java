package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(final List<LottoTicket> lottoTickets) {
        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("lotto tickets is null");
        }

        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoTickets newInstance(final List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets newInstance(LottoTicket... lottoTickets) {
        return new LottoTickets(Arrays.asList(lottoTickets));
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

    public LottoTickets merge(List<LottoTicket> another) {
        List<LottoTicket> newLottoTickets = new ArrayList<>();
        newLottoTickets.addAll(lottoTickets);
        newLottoTickets.addAll(another);
        return new LottoTickets(newLottoTickets);
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }
}
