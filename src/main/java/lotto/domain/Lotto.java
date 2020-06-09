package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final List<Integer> NUMBERS = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
                                                        .boxed()
                                                        .collect(Collectors.toList());

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers){
        validationCheck(numbers);
        this.numbers = numbers;
    }

    public int matchCount(Set<Integer> winningNumbers){
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private void validationCheck(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }

        numbers
                .forEach(
                        number -> {
                            if (number < MIN_VALUE || number > MAX_VALUE) {
                                throw new IllegalArgumentException("로또번호는 1 ~ 45 사이의 숫자로 구성 되어야 합니다.");
                            }
                        }
                );
        ;
    }

    public Set<Integer> getNumbers() {
        return Collections.unmodifiableSet(numbers);
    }
}
