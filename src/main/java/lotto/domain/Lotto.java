package lotto.domain;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        validNumberCountSize(balls);
        this.balls = balls;
    }

    public boolean hasSameNumberCount(Lotto previousLotto, int sameNumberCount) {
        return balls.stream()
                .filter(previousLotto.balls::contains)
                .count() == sameNumberCount;
    }

    private void validNumberCountSize(Set<Ball> balls) {
        if (balls.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호 갯수는 " + NUMBER_SIZE + "개가 되어야합니다. (중복된 숫자도 오면 안됩니다.)");
        }
    }

    @Override
    public String toString() {
        return balls.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new)).toString();
    }
}
