package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> ascendingLottoNumbers() {
        final List<LottoNumber> newLottoNumbers = new ArrayList<>(lottoNumbers);

        Collections.sort(newLottoNumbers);

        return newLottoNumbers;
    }

    public int matchingCount(List<LottoNumber> lottoNumbers) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
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
}
