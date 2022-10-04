package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import lotto.domain.strategy.NumberGenerateStrategy;

public class LottoNumbers implements Iterable<Number> {
    private final List<Number> numbers;

    public LottoNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }
    
    public LottoNumbers match(Number luckyNumber, int matchCount) {
        List<Number> matchNumbers = new ArrayList<>();
        for (Number number : numbers) {
            addMatchNumber(luckyNumber, matchCount, matchNumbers, number);
        }
        return new LottoNumbers(matchNumbers);
    }

    private void addMatchNumber(Number luckyNumber, int matchCount, List<Number> matchNumbers, Number number) {
        if (number.matchCount(luckyNumber) == matchCount) {
            matchNumbers.add(number);
        }
    }

    public int count() {
        return numbers == null ? 0 : numbers.size();
    }
    
    public static LottoNumbers of(NumberGenerateStrategy method, int lottoCount) {
        List<Number> numbers = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            numbers.add(number(method));
        }
        return new LottoNumbers(numbers);
    }
    
    private static Number number(NumberGenerateStrategy method) {
        return new Number(method.createNumbers());
    }

    @Override
    public Iterator<Number> iterator() {
        return numbers.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        LottoNumbers numbers1 = (LottoNumbers) o;
        return numbers.containsAll(numbers1.numbers) && numbers1.numbers.containsAll(numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
