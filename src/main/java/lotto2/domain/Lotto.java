package lotto2.domain;

import java.util.*;

public class Lotto {

    private static int MAX_LOTTO_COUNT = 6;
    private final Set<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = validate(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return new TreeSet<>(lottoNumbers);
    }

    private boolean isLottoNumberMatch(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount += lotto.isLottoNumberMatch(lottoNumber) ? 1 : 0;
        }

        return matchCount;
    }

    private Set<LottoNumber> validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("중복 없이 숫자를 6개 입력해주세요.");
        }
        return new TreeSet<>(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
