package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }

        this.numbers = numbers;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        return distinctNumbers.size() != LOTTO_SIZE;
    }

    public int match(Lotto target) {
        int count = 0;
        for (Integer lottoNumber : numbers) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    int increment(int lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    boolean contains(int lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto of(Integer... numbers) {
        List<Integer> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(number);
        }
        return new Lotto(lotto);
    }

    public static Lotto ofComma(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException();
        }

        String[] values = text.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (String value : values) {
            lotto.add(Integer.parseInt(value.trim()));
        }
        return new Lotto(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(numbers, lotto1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
