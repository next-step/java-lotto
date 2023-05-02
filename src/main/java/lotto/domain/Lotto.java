package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER = 6;
    private List<Integer> numbers;

    public Lotto(String numbers) {
        this.numbers = validate(split(numbers));
    }

    private List<Integer> validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("개수가 6개가 아닙니다.");
        }

        numbers.stream().forEach(number -> checkNumber(number));

        return numbers;
    }

    private void checkNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 로또 번호가 될 수 없습니다.");
        }
    }
    private List<Integer> split(String numbers) {
        String[] number = numbers.split(", ");
        return Arrays.stream(number).map(Integer::parseInt).collect(Collectors.toList());
    }
}
