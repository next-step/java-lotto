package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_BALL_COUNT = 6;

    private final Collection<LottoBall> balls = new HashSet<>();

    public Lotto(Collection<LottoBall> balls) {
        this.balls.addAll(balls);
        this.validate();
    }

    private void validate() {
        if(this.balls.size() != LOTTO_BALL_COUNT) {
            throw new IllegalArgumentException(String.format("로또는 중복된 숫자를 가지거나, %d개의 숫자만을 가져야 합니다.", LOTTO_BALL_COUNT));
        }
    }

    public Collection<LottoBall> getBalls() {
        return this.balls;
    }

    @Override
    public String toString() {
        return new StringBuilder("[")
                .append(this.balls.stream()
                        .sorted()
                        .mapToInt(LottoBall::getBall)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",")))
                .append("]")
                .toString();

    }
}
