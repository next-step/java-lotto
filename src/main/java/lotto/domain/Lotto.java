package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(int ... numbers) {
        this.lottoNumbers = Arrays.stream(numbers).mapToObj(LottoNumber::from).collect(Collectors.toSet());
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 숫자의 갯수는 " + LOTTO_NUMBER_COUNT + "개입니다.");
        }
    }

    public int matchCount(Lotto lotto) {
        Set<LottoNumber> matchCheckSet = new HashSet<>(lotto.lottoNumbers);
        matchCheckSet.retainAll(this.lottoNumbers);
        return matchCheckSet.size();
    }

    public boolean isContains(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    public int getLottoNumbersCount() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().map(lottoNumber -> Integer.parseInt(lottoNumber.toString())).sorted().collect(Collectors.toList()).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
