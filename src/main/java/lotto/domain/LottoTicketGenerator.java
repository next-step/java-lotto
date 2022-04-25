package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoTicketGenerator(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<LottoTicket> generateLottoTickets(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLottoTicket())
                .collect(Collectors.toList());
    }

    private Set<LottoNumber> generateLottoNumbers() {
        return lottoNumberGenerator.generateLottoNumbers();
    }

    private LottoTicket generateLottoTicket() {
        return new LottoTicket(this.generateLottoNumbers());
    }


}
