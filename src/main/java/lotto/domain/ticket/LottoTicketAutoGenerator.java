package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoTicketAutoGenerator implements LottoTicketGenerator {

    @Override
    public LottoTicket generate(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> defaultLottoNumbers = LottoNumber.getDefaultLottoNumbers();
        Collections.shuffle(defaultLottoNumbers);

        List<LottoNumber> subLottoNumbers = defaultLottoNumbers.subList(0, LOTTO_GENERATE_MAX_COUNT);
        return LottoTicket.of(new HashSet<>(subLottoNumbers));
    }
}
