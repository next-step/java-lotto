package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryMachine {

    private static List<Integer> balls;

    public static int getTicketCount(int money) {
        return money / 1000;
    }


    public static List<Integer> getBall(List<Integer> hands) {
        List<Integer> choices = new ArrayList<>();
        for (int hand : hands) {
            choices.add(balls.get(hand));
        }

        return choices;
    }

    public static void run() {
        prepareBalls();
    }

    public static void shuffle() {
        Collections.shuffle(balls);
    }

    private static void prepareBalls() {
        balls = new ArrayList<>();
        balls.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                             21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));
    }
}
