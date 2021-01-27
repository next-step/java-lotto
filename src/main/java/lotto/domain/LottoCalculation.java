package lotto.domain;

import java.util.List;

public class LottoCalculation {

    public Boolean isBonusBall(int number, int bonusBallNumber) {
        return number == bonusBallNumber;
    }

    public Boolean isWinningBall(int number, List<Integer> winningBalls) {
        return winningBalls.contains(number);
    }
}
