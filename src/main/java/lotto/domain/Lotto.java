package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int NUMBER_SIZE = 6;
    public static final String VALID_NUMBER_COUNT = "로또 번호 갯수는 " + NUMBER_SIZE + "개가 되어야합니다. (중복된 숫자도 오면 안됩니다.)";
    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        validNumberCountSize(balls);
        this.balls = balls;
    }

    private void validNumberCountSize(Set<Ball> balls) {
        if (balls.size() != NUMBER_SIZE)
            throw new IllegalArgumentException(VALID_NUMBER_COUNT);
    }

    @Override
    public String toString() {
        return balls.stream().
                sorted().
                collect(Collectors.toCollection(LinkedHashSet::new)).
                toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(balls, lotto.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
