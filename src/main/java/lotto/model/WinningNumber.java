package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 6개이어야 합니다");
        }

        this.numbers = numbers;
    }

    public boolean exists(Integer lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
