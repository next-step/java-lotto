package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoBall {
    private static Map<Integer, LottoBall> lottoBalls = new HashMap<>();
    private final static int RANDOM_BALL_MIN = 1;
    private final static int RANDOM_BALL_MAX = 45;
    private final int number;

    static {
        for (int i = RANDOM_BALL_MIN; i <= RANDOM_BALL_MAX; i++) {
            lottoBalls.put(i, new LottoBall(i));
        }
    }

    private LottoBall(int num) {
        if (num < RANDOM_BALL_MIN || num > RANDOM_BALL_MAX)
            throw new IllegalArgumentException("범위를 벗어난 공 번호 입니다");
        this.number = num;
    }

    public static LottoBall ball(int num) {
        LottoBall lottoBall = lottoBalls.get(num);
        if (lottoBall == null)
            throw new IllegalArgumentException("잘못된 공 번호 입니다");
        return lottoBall;
    }

    public int getNumber() {
        return number;
    }
}
