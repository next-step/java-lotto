package lotto.domain;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_NUMERS = 6;

    private Set<LottoBall> balls = null;

    private Lotto(Set<LottoBall> balls) {
        if (balls.size() != LOTTO_NUMERS) {
            throw new IllegalArgumentException("로또복권은 서로다른 숫자 6자리로 이루어져야한다.");
        }
        this.balls = Sets.newHashSet(balls);
    }

    public Set<LottoBall> getNumbers() {
        return Collections.unmodifiableSet(this.balls);
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

    @Override
    public String toString() {
        return this.balls.toString();
    }

    public static Lotto of(List<LottoBall> balls) {
        Collections.sort(balls);
        return new Lotto(new HashSet<>(balls));
    }
}
