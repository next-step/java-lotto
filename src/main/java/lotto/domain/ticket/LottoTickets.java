package lotto.domain.ticket;

import lotto.domain.PositiveInteger;
import lotto.domain.generator.LottoNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets createByGenerator(LottoNumberGenerator lottoNumberGenerator, PositiveInteger sizeOfTickets) {
        final int LOOP_BEGIN_INDEX = 0;

        return new LottoTickets(IntStream.range(LOOP_BEGIN_INDEX, sizeOfTickets.getValue()).mapToObj(i -> new LottoTicket(lottoNumberGenerator.generate()))
                .collect(Collectors.toList()));
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
