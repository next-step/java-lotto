package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 정확히" + LOTTO_NUMBER_COUNT + "개 여야 합니다.");
        }

        this.lottoNumbers = lottoNumbers;
    }

    public boolean allMatch(final Lotto otherLotto) {
        if (otherLotto == null) {
            return false;
        }

        return lottoNumbers.equals(otherLotto.lottoNumbers);
    }

    public int matchCount(final Lotto otherLotto) {
        if (otherLotto == null) {
            return 0;
        }

        return (int) lottoNumbers.stream()
            .filter(otherLotto.lottoNumbers::contains)
            .count();
    }

    public int size() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
