package lotto.domain;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Lotto {
    protected List<LottoBall> balls = null;

    public Lotto(List<LottoBall> balls) {
        if (balls.size() != LottoMachine.LOTTO_NUMERS || !isUniqueBalls(balls)) {
            throw new IllegalArgumentException("로또복권은 서로다른 숫자 6자리로 이루어져야한다.");
        }
        this.balls = Lists.newArrayList(balls);
        Collections.sort(this.balls);
    }

    private boolean isUniqueBalls(List<LottoBall> balls) {
        return balls.stream().distinct().count() == LottoMachine.LOTTO_NUMERS;
    }

    public List<LottoBall> getNumbers() {
        return Collections.unmodifiableList(this.balls);
    }

    public int howManyMatchBall(Lotto otherLotto) {
        int count = 0;
        for (LottoBall ball : this.balls) {
            count += isInculdeIn(ball, otherLotto);
        }
        return count;
    }

    private int isInculdeIn(LottoBall ball, Lotto lotto) {
        if (ball.isIncludeIn(lotto.getNumbers())) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.balls.toString();
    }
}
