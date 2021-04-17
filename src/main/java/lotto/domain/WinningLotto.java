package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final LottoBalls lottoBalls;

    public WinningLotto(LottoBalls lottoBalls) {
        this.lottoBalls = lottoBalls;
    }

    public static WinningLotto of(Integer... winningBalls) {
        return WinningLotto.of(Arrays.asList(winningBalls));
    }

    public static WinningLotto of(List<Integer> winningBalls) {
        return new WinningLotto(LottoBalls.createWinningLottoBalls(winningBalls));
    }

    public LottoBalls getWinningLottoBalls() {
        return lottoBalls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lottoBalls, that.lottoBalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBalls);
    }
}
