package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBalls {

    private static final List<Integer> balls = new ArrayList<>(
            Arrays.stream(IntStream.range(1, 45).toArray())
                    .boxed()
                    .collect(Collectors.toList()));

    public static List<Integer> get() {
        return balls;
    }
}
