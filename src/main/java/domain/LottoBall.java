package domain;

import java.util.HashMap;
import java.util.Map;

public class LottoBall {
    private static Map<Integer, LottoBall> lottoBalls = new HashMap<>();
    private final int number;

    static {
        for (int i = 1; i < 46; i++) {
            lottoBalls.put(i, new LottoBall(i));
        }
    }

    private LottoBall(int num) {
        if (num < 0 || num > 45)
            throw new IllegalArgumentException("범위를 벗어난 공 번호 입니다");
        this.number = num;
    }

    public static Integer ball(int num) {
        LottoBall lottoBall = lottoBalls.get(num);
        if (lottoBall == null)
            throw new IllegalArgumentException("잘못된 공 번호 입니다");
        return lottoBall.number;
    }
}
