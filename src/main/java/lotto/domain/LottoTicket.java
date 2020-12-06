package lotto.domain;

import lotto.domain.exceptions.InvalidLottoTicketException;

import java.util.*;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);

        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> dupRemovedLottoNumbers = new HashSet<>(lottoNumbers);

        if (dupRemovedLottoNumbers.size() != 6) {
            throw new InvalidLottoTicketException("LottoTicket은 중복 없이 6개의 LottoNumber로만 이루어져야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return this.lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
