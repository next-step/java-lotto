package lotto.core;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Machine {
    private static final List<Ball> list;

    static {
        list = IntStream.rangeClosed(Ball.MIN, Ball.MAX)
                .boxed()
                .map(Ball::new)
                .collect(Collectors.toList());
    }

    public static Ball draw() {
        Collections.shuffle(list);

        return list.get(0);
    }

    public static Ball draw(int number) {
        int index = list.indexOf(new Ball(number));

        return list.get(index);
    }
}
