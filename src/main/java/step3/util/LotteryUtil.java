package step3.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import step3.domain.Lottery;

public class LotteryUtil {

    private static List<Integer> balls;

    public static Set<Integer> getBall() {
        Set<Integer> choices = new HashSet<>();
        prepare();
        shuffle();

        while (Lottery.WINNING_STREAK != choices.size()) {
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
