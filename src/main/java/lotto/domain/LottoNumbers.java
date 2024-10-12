package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumbers {

    private final List<Integer> numbers = new ArrayList<>();
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    public LottoNumbers() {
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .forEach(numbers::add);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public void shuffle() {
        Collections.shuffle(numbers);
    }

    public static void validate(Set<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !isNumberValid(number))) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_START_NUMBER + "부터 " + LOTTO_END_NUMBER + "사이여야 합니다.");
        }
    }

    private static boolean isNumberValid(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

}
