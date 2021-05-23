package lotto.core;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SixBall {
    public static final int LENGTH = 6;

    private final List<Ball> balls;

    private SixBall(Set<Ball> balls) {
        this.balls = balls.stream()
                .limit(LENGTH)
                .sorted().collect(Collectors.toList());
    }

    public static SixBall valueOf(int ...fixedBalls) {
        Set<Ball> balls = initTempCollection(fixedBalls);

        while(balls.size() < LENGTH) {
            balls.add(Machine.draw());
        }

        return new SixBall(balls);
    }

    private static Set<Ball> initTempCollection(int[] fixedBalls) {
        return Arrays.stream(fixedBalls)
                .boxed().map(Machine::draw)
                .collect(Collectors.toSet());
    }

    public Stream<Ball> stream() {
        return balls.stream();
    }

    public boolean contains(Ball ball) {
        return balls.contains(ball);
    }

    @Override
    public String toString() {
        return String.valueOf(balls);
    }
}
