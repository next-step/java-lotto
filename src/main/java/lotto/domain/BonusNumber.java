package lotto.domain;

import java.util.List;

public class BonusNumber {

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 45;
    private final int number;

    public BonusNumber(int number) {
        checkBoundaryNumbers(number);
        this.number = number;
    }

    private static void checkBoundaryNumbers(int number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new IllegalArgumentException("1이상 45이하의 숫자만 입력할 수 있습니다.");
        }
    }

    public boolean match(List<LottoNumber> numbers) {
        return numbers.stream().anyMatch(item -> item.getNumber() == this.number);
    }

    public int getNumber() {
        return number;
    }
}
