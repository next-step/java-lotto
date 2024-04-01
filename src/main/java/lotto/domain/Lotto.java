package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final String LOTTO_LENGTH_ERROR_MESSAGE = "로또 숫자는 %d개여야 합니다.";
    public static final String SEPARATOR = ",";

    private Set<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = new HashSet<>(lotto);
        validateLotto();
    }

    private void validateLotto() {
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format(LOTTO_LENGTH_ERROR_MESSAGE, LOTTO_SIZE));
        }
    }

    public static Lotto createFromNumbers(List<Integer> numbers) {
        return of(numbers.toArray(new Integer[0]));
    }

    public static Lotto createFromString(String text) {
        String[] numbers = text.split(SEPARATOR);
        return of(toIntegers(numbers));
    }

    private static Integer[] toIntegers(String[] strings) {
        Integer[] integers = Arrays.stream(strings)
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        return integers;
    }

    public static Lotto of(Integer... numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public int matchCount(Lotto otherLotto) {
        return (int) this.lotto.stream()
                .filter(otherLotto::isContains)
                .count();
    }

    private boolean isContains(LottoNumber number) {
        return this.lotto.contains(number);
    }

    public String sortNumbers() {
        List<Integer> sortedNumbers = lotto.stream()
                .map(LottoNumber::toInt)
                .sorted()
                .collect(Collectors.toList());
        return sortedNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return String.valueOf(lotto);
    }
}
