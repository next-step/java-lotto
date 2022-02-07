package lotto.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.WinningBall;

public class WinningBallFactory {

    private WinningBallFactory() {
    }

    public static List<WinningBall> of(String[] numbers, String bonusNumber) {
        validateBonusNumberDuplication(numbers, bonusNumber);
        List<WinningBall> balls = Arrays.stream(numbers)
            .map(WinningBall::new)
            .collect(Collectors.toList());

        balls.add(new WinningBall(bonusNumber, true));
        return balls;
    }

    private static void validateBonusNumberDuplication(String[] numbers, String bonusNumber) {
        if(Arrays.asList(numbers).contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 같습니다.");
        }
    }
}
