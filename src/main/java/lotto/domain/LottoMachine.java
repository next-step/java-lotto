package lotto.domain;

import lotto.utils.LottoHelper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private List<LottoBall> balls = null;

    public LottoMachine() {
        this.balls = makeBalls();
    }

    public Lotto createLotto() {
        return createLotto(LottoHelper.pickRandomBalls(this.balls, Lotto.LOTTO_NUMERS));
    }

    public Lotto createLotto(List<LottoBall> balls) {
        return new Lotto(balls);
    }

    public WInningLotto createWinningLotto(String winningNumbers, int bonusNumber) {
        return new WInningLotto(createLotto(LottoHelper.convertToBalls(winningNumbers)), LottoHelper.convertToBall(bonusNumber));
    }

    private List<LottoBall> makeBalls() {
        return IntStream.range(LottoBall.LOTTO_MIN_NUMBER, LottoBall.LOTTO_MAX_NUMBER).mapToObj(number -> new LottoBall(number)).collect(Collectors.toList());
    }
}
