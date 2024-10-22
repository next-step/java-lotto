package lotto.domain.ticket;

import lotto.application.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketGenerator {

    public LottoTicket getPassiveTicket(List<Integer> passiveLottoNumbers) {
        return new LottoTicket(passiveLottoNumbers.stream()
                                                  .map(LottoNumber::new)
                                                  .collect(Collectors.toList()));
    }

    public LottoTicket getAutoTicket(LottoGenerator lottoGenerator) {
        return new LottoTicket(lottoGenerator.getLottoNumbers());
    }

}
