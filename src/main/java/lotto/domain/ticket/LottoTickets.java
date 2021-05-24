package lotto.domain.ticket;

import lotto.domain.PositiveNumber;
import lotto.domain.generator.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
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
        return Collections.unmodifiableList(lottoTickets);
    }
}
