package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class LottoTicket {
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    private void validate(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(format("로또티켓은 %d개의 번호를 가져야 합니다.", LOTTO_NUMBERS_SIZE));
        }
    }
}
