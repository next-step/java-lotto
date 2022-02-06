package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningBall {

    private final int number;
    private final boolean isBonus;

    public WinningBall(String number) {
        this(number, false);
    }

    public WinningBall(String number, boolean isBonus) {
        this(Integer.parseInt(number), isBonus);
    }

    public WinningBall(int number, boolean isBonus) {
        this.number = number;
        this.isBonus = isBonus;
    }

    public static List<WinningBall> getWinningBalls(String[] numbers, String bonusNumber) {
        List<WinningBall> balls = Arrays.stream(numbers)
            .map(WinningBall::new)
            .collect(Collectors.toList());

        balls.add(new WinningBall(bonusNumber, true));
        return balls;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
