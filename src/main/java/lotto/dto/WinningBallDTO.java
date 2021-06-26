package lotto.dto;

import lombok.Getter;
import lotto.core.round.Round;
import lotto.core.round.WinSixBall;
import lotto.util.StringUtils;

@Getter
public class WinningBallDTO {
    private int[] fixedBalls;
    private int bounsBall;

    public void setFixedBalls(final String fixedBalls) {
        try {
            this.fixedBalls = StringUtils.csvToDistinctIntArray(fixedBalls);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 숫자만 가능합니다.");
        }
    }

    public void setBounsBall(final String bounsBall) {
        try {
            this.bounsBall = Integer.parseInt(bounsBall);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("보너스 볼은 숫자만 가능합니다.");
        }
    }

    public Round toRound() {
        return new Round(WinSixBall.valueOf(fixedBalls), bounsBall);
    }
}
