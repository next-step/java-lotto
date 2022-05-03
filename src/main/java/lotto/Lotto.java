package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(int[] numbers) {
        this(IntStream.of(numbers)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNumber> numbers) {
        validateNumberSize(numbers.size());
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public Rank getRank(Lotto winningLotto) {
        return Rank.valueOfMatchCount(matchLottoNumberCount(winningLotto));
    }

    private int matchLottoNumberCount(Lotto winningLotto) {
        List<LottoNumber> sameNumbers = new ArrayList<>(this.numbers);
        sameNumbers.retainAll(new HashSet<>(winningLotto.numbers));
        return sameNumbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers.stream().map(LottoNumber::getNumber).sorted().collect(Collectors.toList()));
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

        return numbers != null ? numbers.equals(lotto.numbers) : lotto.numbers == null;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
