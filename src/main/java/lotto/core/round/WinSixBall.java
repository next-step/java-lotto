package lotto.core.round;

import lotto.core.SixBall;

public final class WinSixBall {
    private final SixBall sixBall;

    private WinSixBall(final SixBall sixBall) {
        this.sixBall = sixBall;
    }

    public static WinSixBall valueOf(int ...fixedBalls) {
        if (fixedBalls.length < SixBall.LENGTH) {
            throw new IllegalArgumentException(String.format("당첨 번호는 총 %d개를 입력해주셔야 합니다.", SixBall.LENGTH));
        }

        return new WinSixBall(SixBall.valueOf(fixedBalls));
    }

    public SixBall toSixBall() {
        return sixBall;
    }
}
