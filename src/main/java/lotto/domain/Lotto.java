package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int SIZE = 6;
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 45;
    private static final List<LottoNumber> baseNumbers = IntStream.rangeClosed(RANGE_START, RANGE_END).mapToObj(LottoNumber::new).collect(Collectors.toList());

    private final Set<LottoNumber> numbers;

    public Lotto() {
        Collections.shuffle(baseNumbers);
        this.numbers = new TreeSet<>(baseNumbers.subList(0, SIZE));
    }

    public Lotto(List<Integer> numbers) {
        this(numbers.stream().map(LottoNumber::new).collect(Collectors.toCollection(TreeSet::new)));
    }

    public Lotto(Set<LottoNumber> numbers) {
        this.numbers = checkArgumentValidation(numbers);
    }

    private Set<LottoNumber> checkArgumentValidation(Set<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("Lotto의 List<Integer> size는 항상 6입니다.");
        }
        return numbers;
    }

    public Set<LottoNumber> getNumbers() {
        return this.numbers;
    }

    public boolean containBonusNumber(int bonusNumber) {
        return numbers.contains(new LottoNumber(bonusNumber));
    }
}
