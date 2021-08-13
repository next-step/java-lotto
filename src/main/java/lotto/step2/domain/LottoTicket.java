package lotto.step2.domain;

import java.util.Objects;
import java.util.Set;

public class LottoTicket {
    private static final int LOTTO_COUNT = 6;
    private Set<LottoNumber> lottoNumbers;

    public LottoTicket(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 숫자의 개수는 " + LOTTO_COUNT + "개이어야 합니다.");
        }
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
