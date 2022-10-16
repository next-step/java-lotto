package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final List<Integer> numbers;

    private WinningNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 6개이어야 합니다");
        }

        this.numbers = numbers;
    }

    public static WinningNumber of(List<Integer> numbers) {
        return new WinningNumber(numbers);
    }

    public static WinningNumber from(String stringNumbers) {
        return new WinningNumber(Arrays.stream(stringNumbers.split(", ")).map(Integer::valueOf).collect(Collectors.toList()));
    }

    public boolean exists(Integer lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
