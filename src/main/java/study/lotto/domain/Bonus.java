package study.lotto.domain;

import java.util.List;

public class Bonus {
    private int number;

    public Bonus(int number, List<Integer> lastWeekNumbers) {
        this.number = number;
        validate(lastWeekNumbers);
    }

    public int getNumber() {
        return number;
    }

    public void validate(List<Integer> lastWeekNumbers) {
        if (lastWeekNumbers.contains(number)) {
            throw new RuntimeException("보너스 숫자는 로또 결과 숫자와 중복일 수 없습니다.");
        }
    }
}
