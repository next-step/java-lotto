package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
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
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public int matchNumber(Lotto lotto) {
        return this.lottoNumbers.stream()
                .mapToInt(lotto::increase)
                .sum();
    }

    public int increase(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
    }

    public Ranking findRankingByLotto(final Lotto winningLotto) {
        return Ranking.valueOfRanking(matchNumber(winningLotto));
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
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
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
