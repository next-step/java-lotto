package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int SIZE = 6;
    private static final String LOTTO_SIZE_EXCEPTION_MESSAGE = "로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_BALLS_EXCEPTION_MESSAGE = "로또 번호가 중복되었습니다.";
    private final List<Ball> balls;

    public Lotto(final List<Ball> balls) {
        validate(balls);
        balls.sort(Comparator.naturalOrder());
        this.balls = balls;
    }

    private void validate(final List<Ball> balls) {
        if (balls.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException(DUPLICATE_BALLS_EXCEPTION_MESSAGE);
        }
        if (balls.size() != SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION_MESSAGE);
        }
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
        for (int i = 0; i < SIZE; i++) {
            if (!lotto.balls.get(i).equals(this.balls.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
