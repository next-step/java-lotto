package lotto.domain.winning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.user.UserLotto;
import lotto.dto.WinningInfo;

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

    public WinningInfo getWinningInfoOf(UserLotto userLotto) {
        int count = 0;
        boolean hasBonus = false;

        for (WinningBall winningBall : winningBalls) {
            if (userLotto.contains(winningBall.getNumber())) {
                count++;
            }
            if (userLotto.contains(winningBall.getNumber()) && winningBall.isBonus()) {
                hasBonus = true;
            }
        }

        return new WinningInfo(count, hasBonus);
    }

    private void validateBonusNumberDuplication(String[] numbers, String bonusNumber) {
        if (Arrays.asList(numbers).contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 같습니다.");
        }
    }
}
