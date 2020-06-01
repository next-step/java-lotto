package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.HashSet;
import java.util.List;

public class LottoTicketManualGenerator {

    public LottoTicket generate(List<LottoNumber> lottoNumbers) {
        return LottoTicket.of(new HashSet<>(lottoNumbers));
    }
}
