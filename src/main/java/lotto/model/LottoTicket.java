package lotto.model;

import lotto.exception.InvalidLottoTicketException;

import java.util.Collections;
import java.util.Set;

public class LottoTicket {

    private static final int MAX_LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_SIZE) {
            throw new InvalidLottoTicketException();
        }
    }

    public int countMatches(LottoTicket lottoTicket) {
        return (int) lottoTicket.getLottoNumbers().stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    private Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
