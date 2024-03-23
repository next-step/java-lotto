package domain;

import java.util.*;

public class Lotto {

    public static final int PRICE = 1_000;

    private final List<Integer> numbers;

    public Lotto() {
        this(new RandomLottoFactory().create().numbers());
    }

    public Lotto(List<Integer> numbers) {
        assertListSizeOfSix(numbers);
        List<Integer> newNumbers = new ArrayList<>(numbers);
        Collections.sort(newNumbers);
        this.numbers = newNumbers;
    }

    private void assertListSizeOfSix(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 갯수가 6개가 아닙니다.");
        }
    }

    public List<Integer> numbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
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
        return Objects.hash(numbers);
    }
}
