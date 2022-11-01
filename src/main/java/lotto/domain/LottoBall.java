package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoBall {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private final int number;
    private static final Map<Integer, LottoBall> lottoBallMap = new HashMap<>();

    static {
        IntStream.range(START_LOTTO_NUMBER, END_LOTTO_NUMBER + 1)
                .mapToObj(idx -> lottoBallMap.put(idx, new LottoBall(idx)));
    }

    public LottoBall(int number) {
        this.number = number;
    }

    public static int getStartNumber() {
        return START_LOTTO_NUMBER;
    }

    public static int getLastNumber() {
        return END_LOTTO_NUMBER;
    }
}
