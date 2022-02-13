package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningBalls {

    private final List<WinningBall> winningBalls;

    public WinningBalls(String[] numbers, String bonusNumber) {
        validateBonusNumberDuplication(numbers, bonusNumber);
        winningBalls = createWinningBalls(numbers, bonusNumber);
    }

    private List<WinningBall> createWinningBalls(String[] numbers, String bonusNumber) {
        List<WinningBall> balls = Arrays.stream(numbers)
            .map(WinningBall::new)
            .collect(Collectors.toList());

        balls.add(new WinningBall(bonusNumber, true));
        return balls;
    }

    private void validateBonusNumberDuplication(String[] numbers, String bonusNumber) {
        if (Arrays.asList(numbers).contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 같습니다.");
        }
    }

    public List<WinningBall> getWinningBalls() {
        return new ArrayList<>(winningBalls);
    }
}
