package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public LottoTicket printTicket(int amount) {
        return LottoTicket.of(IntStream.range(0, amount)
                .mapToObj(x -> lottoGenerator.generate())
                .collect(Collectors.toList()));
    }
}
