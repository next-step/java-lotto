package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final LottoBalls lottoBalls;

    public Lotto() {
        lottoBalls = new LottoBalls(createAutoLotto());
    }

    public Lotto(LottoBalls lottoBalls) {
        this.lottoBalls = lottoBalls;
    }

    public static Lotto of(List<Integer> winningBalls) {
        return new Lotto(LottoBalls.createWinningLottoBalls(winningBalls));
    }

    public List<LottoBall> createAutoLotto() {
        List<LottoBall> lottoBallList = LottoBall.LOTTO_BALL_CACHE;
        Collections.shuffle(lottoBallList);
        return lottoBallList.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList());
    }

    public int countMatch(WinningLotto winningLotto) {
        return lottoBalls.count(winningLotto.getWinningLottoBalls());
    }

    public boolean containsBonus(WinningLotto winningLotto) {
        return lottoBalls.checkBonus(winningLotto.getBonusBall());
    }

    public LottoBalls getLottoBalls() {
        return lottoBalls;
    }
}
