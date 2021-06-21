package lotto.dto;

import lombok.Getter;
import lombok.ToString;
import lotto.core.Ball;
import lotto.core.Machine;
import lotto.core.SixBall;
import lotto.core.round.Round;
import lotto.util.StringUtils;

@Getter
@ToString
public class WinningBallDTO extends BaseRequestDTO<Round> {
    private SixBall fixedBall;
    private Ball bounsBall;

    public void setFixedBalls(final String textFixed) {
        int[] fixeds = getFixedBalls(textFixed);

        if (SixBall.isLengthValidation(fixeds.length)) {
            throw new IllegalArgumentException(String.format("당첨 번호는 총 %d개를 입력해주셔야 합니다.", SixBall.LENGTH));
        }

        this.fixedBall = SixBall.valueOf(fixeds);
    }

    public void setBounsBall(final String textBounsBall) {
        int bonus = parseIntElseThrow(textBounsBall, "보너스 볼은 숫자만 가능합니다.");

        this.bounsBall = Machine.draw(bonus);
    }

    private int[] getFixedBalls(final String balls) {
        try {
            return StringUtils.csvToDistinctIntArray(balls);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 숫자만 가능합니다.");
        }
    }

    @Override
    public Round toEntity() {
        return new Round(fixedBall, bounsBall);
    }
}
