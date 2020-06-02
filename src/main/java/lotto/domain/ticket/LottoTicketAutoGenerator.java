package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicketAutoGenerator {

    private static final int LOTTO_GENERATE_MAX_COUNT = 6;

    public LottoTicket generate(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> subLottoNumbers = lottoNumbers.subList(0, LOTTO_GENERATE_MAX_COUNT);
        return LottoTicket.of(new HashSet<>(subLottoNumbers));
    }
}
