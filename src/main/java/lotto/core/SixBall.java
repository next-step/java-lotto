package lotto.core;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SixBall {
    private static final int LENGTH = 6;

    private final List<Ball> balls;

    private SixBall(Set<Ball> balls) {
        this.balls = balls.stream()
                .sorted().collect(Collectors.toList());
    }

    public static SixBall get() {
        Set<Ball> balls = new HashSet<>();
        while(balls.size() < LENGTH) {
            balls.add(Machine.draw());
        }

        return new SixBall(balls);
    }

    public Stream<Ball> stream() {
        return balls.stream();
    }

    @Override
    public String toString() {
        return String.valueOf(balls);
    }
}
