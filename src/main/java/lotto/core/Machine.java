package lotto.core;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Machine {
    private static final List<Ball> balls;
    private static final int RANDOM_PICK = 0;

    static {
        balls = IntStream.rangeClosed(Ball.MIN, Ball.MAX)
                .boxed()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public static Ball draw() {
        Collections.shuffle(balls);

        return balls.get(RANDOM_PICK);
    }

    public static Ball draw(int number) {
        int index = balls.indexOf(new Ball(number));

        return balls.get(index);
    }
}
