package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.LottoNumber;

public class LottoBalls {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_BALL = 6;

    private static final List<LottoNumber> BALLS = new ArrayList<>(
            IntStream.range(LOTTO_START_NUMBER, LOTTO_END_NUMBER + 1)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList()));

    private LottoBalls() {}

    public static void shuffle() {
        Collections.shuffle(BALLS);
    }

    public static Set<LottoNumber> getRandomLottoNumber() {
        return new TreeSet<>(BALLS.subList(0, NUMBER_OF_LOTTO_BALL));
    }

    public static List<LottoNumber> get() {
        return BALLS;
    }
}
