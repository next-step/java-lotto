package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {

    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;

    private static final List<String> balls = new ArrayList<>(
        Arrays.stream(IntStream.range(LOTTO_START_NUMBER, LOTTO_END_NUMBER + 1).toArray())
            .boxed()
            .map(String::valueOf)
            .collect(Collectors.toList()));

    public static List<String> get() {
        return balls;
    }
}
