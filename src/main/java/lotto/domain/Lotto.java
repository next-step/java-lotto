package lotto.domain;

import lotto.pattern.LottoNumberGenerateStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public Lotto(int[] numbers) {
        this(IntStream.of(numbers)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this(lottoNumberGenerateStrategy.generate());
    }

    public LottoRank getLottoRank(Lotto winningLotto) {
        return LottoRank.valueOfMatchCount(matchLottoNumberCount(winningLotto));
    }

    private int matchLottoNumberCount(Lotto winningLotto) {
        List<LottoNumber> sameNumbers = new ArrayList<>(this.numbers);
        sameNumbers.retainAll(new HashSet<>(winningLotto.numbers));
        return sameNumbers.size();
    }

    public List<Integer> getNumbers() {
        return this.numbers.stream().map(LottoNumber::getNumber).sorted().collect(Collectors.toUnmodifiableList());
    }

    private void validateLottoNumber(List<LottoNumber> numbers) {
        validateNumberSize(numbers.size());
        validateDuplicateNumbers(numbers);
    }

    private void validateNumberSize(int numberSize) {
        if (numberSize != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 숫자 갯수는 6개 입니다.");
        }
    }

    private void validateDuplicateNumbers(List<LottoNumber> numbers) {
        Set<LottoNumber> nonDuplicateNumber = new HashSet<>(numbers);
        if (nonDuplicateNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 중복될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
