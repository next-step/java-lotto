package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(Integer... input) {
        this(Arrays.stream(
                Optional.ofNullable(input).orElseGet(() -> new Integer[0]))
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(String[] input) {
        this(Arrays.stream(
                Optional.ofNullable(input).orElseGet(() -> new String[0]))
                .map(it -> Integer.valueOf(it.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> input) {
        validatePolicy(input);
        this.lottoNumbers = input;
    }

    private void validatePolicy(List<LottoNumber> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 로또 번호로 구성되어야 합니다.");
        }
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.lottoNumbers.stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public Boolean checkContainsLottoNumber(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> values() {
        return lottoNumbers;
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
