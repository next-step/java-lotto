package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
//TODO: 로또넘버로 값을 포장해보는 것은 어떨까요? - 이게 무슨소리?
    private final int number;
    private final boolean isBonus;

    public WinningNumber(String number) {
        this(number, false);
    }

    public WinningNumber(int number) {
        this(number, false);
    }

    public WinningNumber(String number, boolean isBonus) {
        this(Integer.parseInt(number), isBonus);
    }

    public WinningNumber(int number, boolean isBonus) {
        this.number = number;
        this.isBonus = isBonus;
    }

    public static List<WinningNumber> getWinningNumbers(String[] numbers, String bonusNumber) {
        List<WinningNumber> balls = Arrays.stream(numbers)
            .map(WinningNumber::new)
            .collect(Collectors.toList());

        balls.add(new WinningNumber(bonusNumber, true));
        return balls;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
