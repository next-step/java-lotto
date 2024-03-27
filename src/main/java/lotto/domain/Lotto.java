package lotto.domain;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;


public class Lotto {

    private final SortedSet<Integer> numbers;

    public static final int LOTTO_NUMBER_LIMIT = 6;

    public Lotto(List<Integer> numbers) {
        this(new TreeSet<>(numbers));
    }

    public Lotto(TreeSet<Integer> numbers) {
        if (numbers.size() < LOTTO_NUMBER_LIMIT)
            throw new IllegalArgumentException("로또의 숫자는 6개이여야 합니다. 주어진 숫자는 " + numbers.size());
        this.numbers = numbers;
    }

    public Integer countMatchNumbers(List<Integer> answerSheetNumbers) {
        return (int) answerSheetNumbers.stream().filter(numbers::contains).count();
    }

    public boolean containsNumber(Integer number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
