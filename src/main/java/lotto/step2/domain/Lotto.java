package lotto.step2.domain;

import java.util.List;

public class Lotto {

    private Numbers numbers;

    public Lotto() {
        this.numbers = new Numbers();
    }
    // 테스트 편의 생성자
    public Lotto(Numbers numbers) {
        this.numbers = numbers;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public boolean isMatchExpected(List<Integer> winningNumbers, int expected) {
        return numbers.getCountOfMatch(winningNumbers) == expected;
    }

}
