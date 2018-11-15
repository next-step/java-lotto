package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;

public class Lotto {
    public static enum LottoType {
        AUTO, MANUAL, WINNING;
    }
    
    public static final int LOTTO_NUMERS = 6;

    private LottoType type;
    private Set<LottoBall> balls = null;

    private Lotto(LottoType type, Set<LottoBall> balls) {
        if (balls.size() != LOTTO_NUMERS) {
            throw new IllegalArgumentException("로또복권은 서로다른 숫자 6자리로 이루어져야한다.");
        }
        this.type = type;
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
    
    public boolean isType(LottoType type) {
        return this.type == type;
    }

    @Override
    public String toString() {
        return this.balls.toString();
    }

    public static Lotto ofManual(List<LottoBall> lottoBalls) {
        return new Lotto(LottoType.MANUAL, new HashSet<LottoBall>(lottoBalls));
    }
    
    public static Lotto ofAuto(List<LottoBall> lottoBalls) {
        return new Lotto(LottoType.AUTO, new HashSet<LottoBall>(lottoBalls));
    }
}
