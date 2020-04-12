package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(final List<LottoTicket> lottoTickets) {
        if (Objects.isNull(lottoTickets)) {
            throw new IllegalArgumentException("로또 객체가 올바르지 않습니다.");
        }

        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoTickets newInstance(final List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets newInstance(final LottoTicket... lottoTickets) {
        return new LottoTickets(Arrays.asList(lottoTickets));
    }

    public LottoWinningResults checkAll(final WinningLottoTicket winningLottoTicket) {
        List<LottoWinningResult> lottoWinningResults = lottoTickets.stream()
                .map(winningLottoTicket::check)
                .collect(Collectors.toList());

        return LottoWinningResults.create(lottoWinningResults);
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoTickets merge(final List<LottoTicket> another) {
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
