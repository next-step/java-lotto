package step2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class LotteryUtil {

    public static final int WINNING_STREAK = 6;
    private static List<Integer> balls;

    public static Set<Integer> getBall() {
        Set<Integer> choices = new HashSet<>();
        prepare();
        shuffle();

        while (choices.size() != WINNING_STREAK) {
            choices.add(balls.get(ThreadLocalRandom.current().nextInt(0, 45)));
        }

        return choices;
    }

    private static void shuffle() {
        Collections.shuffle(balls);
    }

    private static void prepare() {
        balls = new ArrayList<>();
        for (int ball = 1; ball <= 45; ball++) {
            balls.add(ball);
        }
    }
}
