package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningBall;

public class WinningBalls {

    private WinningBalls() {

    }

    public static List<WinningBall> of(String[] numbers, String bonusNumber) {
        List<WinningBall> balls = Arrays.stream(numbers)
            .map(WinningBall::new)
            .collect(Collectors.toList());

        balls.add(new WinningBall(bonusNumber, true));
        return balls;
    }
}
