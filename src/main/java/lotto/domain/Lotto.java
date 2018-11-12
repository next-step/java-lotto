package lotto.domain;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static enum LottoType {
        AUTO, MANUAL, WINNING;
    }

    public static final int LOTTO_NUMERS = 6;

    private LottoType type = null;
    private List<LottoBall> balls = null;

    public Lotto(List<LottoBall> balls) {
        this(LottoType.AUTO, balls);
    }

    public Lotto(LottoType type, List<LottoBall> balls) {
        if (balls.size() != LOTTO_NUMERS || !isUniqueBalls(balls)) {
            throw new IllegalArgumentException("로또복권은 서로다른 숫자 6자리로 이루어져야한다.");
        }
        this.type = type;
        this.balls = Lists.newArrayList(balls);
        Collections.sort(this.balls);
    }

    private boolean isUniqueBalls(List<LottoBall> balls) {
        return balls.stream().distinct().count() == LOTTO_NUMERS;
    }

    public List<LottoBall> getNumbers() {
        return Collections.unmodifiableList(this.balls);
    }

    public int howManyMatchBall(Lotto otherLotto) {
        int count = 0;
        for (LottoBall ball : this.balls) {
            if (otherLotto.hasBall(ball)) {
                count++;
            }
        }
        return count;
    }

    public boolean hasBall(LottoBall bonusBall) {
        return this.balls.contains(bonusBall);
    }

    public boolean isType(LottoType type) {
        return this.type == type;
    }

    @Override
    public String toString() {
        return this.balls.toString();
    }
}
