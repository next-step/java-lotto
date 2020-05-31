package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.TreeSet;

public class LottoTicketManualGenerator implements LottoTicketGenerator {

    public LottoTicket generate(List<LottoNumber> lottoNumbers) {
        return LottoTicket.of(new TreeSet<>(lottoNumbers));
    }
}
