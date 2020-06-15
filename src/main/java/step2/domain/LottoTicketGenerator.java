package step2.domain;

import step2.domain.strategy.LottoNumberGeneratorStrategy;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketGenerator {
    private LottoTicket lottoTicket;

    public LottoTicketGenerator(int lottoAmount, LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        this.lottoTicket = new LottoTicket(Stream.generate(Lotto::new)
                .limit(lottoAmount)
                .collect(Collectors.toList()), lottoNumberGeneratorStrategy);
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }
}
