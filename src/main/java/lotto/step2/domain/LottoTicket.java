package lotto.step2.domain;

import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int matchWinningNumber(LottoTicket winningNumber) {
        int matchCount = 0;
        for (LottoNumber num : lottoNumbers) {
            matchCount += winningNumber.contains(num);
        }

        return matchCount;
    }

    private int contains(LottoNumber num) {
        if (lottoNumbers.contains(num)) {
            return 1;
        }
        return 0;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
