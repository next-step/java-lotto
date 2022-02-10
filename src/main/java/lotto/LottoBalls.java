package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class LottoBalls {

    private final static int LOTTO_START_NUMBER = 1;
    private final static int LOTTO_END_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_BALL = 6;

    private LottoBalls() {}

    private static final List<LottoNumber> balls = new ArrayList<>(
            Arrays.stream(IntStream.range(LOTTO_START_NUMBER, LOTTO_END_NUMBER + 1).toArray())
                    .mapToObj(String::valueOf)
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));

    public static void shuffle() {
        Collections.shuffle(balls);
    }

    public static Set<LottoNumber> createLottoNumber() {
        return new TreeSet<>(balls.subList(0, NUMBER_OF_LOTTO_BALL));
    }

    public static List<LottoNumber> get() {
        return balls;
    }
}
