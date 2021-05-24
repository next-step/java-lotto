package lotto.domain.ticket;

import lotto.domain.PositiveNumber;
import lotto.domain.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoTickets {
    public static final LottoTickets EMPTY_LOTTO_TICKETS = new LottoTickets(new ArrayList<>());

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public static LottoTickets createByGenerator(
            LottoNumberGenerator lottoNumberGenerator,
            PositiveNumber sizeOfTickets) {
        final int LOOP_BEGIN_INDEX = 0;

        return new LottoTickets(LongStream.range(LOOP_BEGIN_INDEX, sizeOfTickets.toLong())
                .mapToObj(i -> new LottoTicket(lottoNumberGenerator.generate()))
                .collect(Collectors.toList()));
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getTickets() {
        return lottoTickets;
    }

    public LottoTickets add(LottoTickets dest) {
        List<LottoTicket> lottoTickets = new ArrayList<>(this.lottoTickets);
        lottoTickets.addAll(dest.lottoTickets);

        return new LottoTickets(lottoTickets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
