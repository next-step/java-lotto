package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(final int... numbers) {
        this(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }
    
    public LottoNumber(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public MatchingCount matchCount(LottoNumber other, BonusNumber bonusNumber) {
        return new MatchingCount(matchingCount(other), contains(bonusNumber));
    }
    
    public List<Integer> numbers() {
        return numbers;
    }

    public int count() {
        return numbers == null ? 0 : numbers.size();
    }

    private int matchingCount(LottoNumber other) {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(other.numbers);
        return numbers.size();
    }
    
    private boolean contains(BonusNumber number) {
        return numbers.contains(number.value());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        LottoNumber lottoNumber = (LottoNumber) o;
        return numbers.containsAll(lottoNumber.numbers) && lottoNumber.numbers.containsAll(numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
