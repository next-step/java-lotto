package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    static final int SIZE = 6;
    static final int PRICE = 1000;
    private static final String LOTTO_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_BALLS_EXCEPTION_MESSAGE = "로또 번호가 중복되었습니다.";

    private final List<Ball> balls;

    public Lotto(final List<Ball> balls) {
        validate(balls);
        balls.sort(Comparator.naturalOrder());
        this.balls = balls;
    }

    private void validate(final List<Ball> balls) {
        validateLottoSize(balls);
        validateDuplicate(balls);
    }

    private void validateDuplicate(final List<Ball> balls) {
        if (balls.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException(DUPLICATE_BALLS_EXCEPTION_MESSAGE);
        }
    }

    private void validateLottoSize(final List<Ball> balls) {
        if (balls.size() != SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public int getDuplicateBallCount(final Lotto lotto) {
        Set<Ball> lottoBalls = new HashSet<>(this.balls);
        lottoBalls.retainAll(lotto.balls);
        return lottoBalls.size();
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(this.balls);
    }

    public boolean isContains(final Ball ball) {
        return this.balls.contains(ball);
    }

    public static Money calculatePurchaseMoney(LottoBuyCount lottoBuyCount) {
        return new Money(PRICE * lottoBuyCount.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;

        return getDuplicateBallCount(lotto) == SIZE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
