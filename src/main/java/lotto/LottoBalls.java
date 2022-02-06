package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {

    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_BALL = 6;


    private static final List<String> balls = new ArrayList<>(
            Arrays.stream(IntStream.range(LOTTO_START_NUMBER, LOTTO_END_NUMBER + 1).toArray())
                    .boxed()
                    .map(String::valueOf)
                    .collect(Collectors.toList()));

    public static boolean isContains(String value) {
        return balls.contains(value);
    }

    public static boolean isContains(List<String> numbers) {
        return balls.containsAll(numbers);
    }

    public static void shuffle() {
        Collections.shuffle(balls);
    }

    public static List<String> createLottoNumber() {
        return balls.subList(0, NUMBER_OF_LOTTO_BALL);
    }

    public static List<String> get() {
        return balls;
    }
}
