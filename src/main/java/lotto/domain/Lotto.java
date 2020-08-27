package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String NOT_VALID_LOTTO_SIZE = "로또 번호의 사이즈는 %d개 입니다.";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = new TreeSet<>(lottoNumbers);
    }

    public static Lotto of(Set<LottoNumber> lottoNumberSet) {
        return new Lotto(lottoNumberSet);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public static Lotto of(String input) {
        return new Lotto(Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public int matchNumber(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Ranking findRankingByLotto(Lotto lotto, LottoNumber lottoNumber) {
        return Ranking.valueOfRanking(matchNumber(lotto), hasNumber(lottoNumber));
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format(NOT_VALID_LOTTO_SIZE, LOTTO_SIZE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto that = (Lotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(SEPARATOR, PREFIX, SUFFIX));
    }
}
