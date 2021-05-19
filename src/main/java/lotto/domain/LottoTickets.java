package lotto.domain;

import lotto.domain.generator.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;

public class LottoTickets {
    private static final int GENERATE_MINIMUM_SIZE = 0;

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets createByGenerator(LottoNumberGenerator lottoNumberGenerator, int size) {
        if (size < GENERATE_MINIMUM_SIZE) {
            throw new IllegalArgumentException(format("%d개 부터 만들 수 있습니다.", size));
        }

        return new LottoTickets(IntStream.range(0, size).mapToObj(i -> new LottoTicket(lottoNumberGenerator.generate()))
                .collect(Collectors.toList()));
    }

    public int size() {
        return lottoTickets.size();
    }
}
