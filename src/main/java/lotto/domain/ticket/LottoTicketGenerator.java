package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.List;

@FunctionalInterface
public interface LottoTicketGenerator {

    int LOTTO_GENERATE_MAX_COUNT = 6;

    LottoTicket generate(List<LottoNumber> lottoNumbers);
}
