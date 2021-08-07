package lotto.domain;

import java.util.List;
import java.util.Objects;

public final class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validationCheck(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validationCheck(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("different number size");
        }
    }

    public int matchingTicket(final List<Integer> winningNumbers) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount = getMatchCount(winningNumbers, lottoNumber, matchCount);
        }
        return matchCount;
    }

    private int getMatchCount(final List<Integer> winningNumbers, final LottoNumber lottoNumber, int matchCount) {
        if (winningNumbers.contains(lottoNumber.getNumber())) {
            matchCount++;
        }
        return matchCount;
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
