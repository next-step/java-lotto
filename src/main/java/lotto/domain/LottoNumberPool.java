package lotto.domain;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by seungwoo.song on 2022-10-14
 */
public class LottoNumberPool {

    public static final int MAX_LOTTO_NUMBER = 45;

    private final static List<LottoNumber> LOTTO_NUMBERS_CACHE;

    static {
        LOTTO_NUMBERS_CACHE = IntStream.range(1, MAX_LOTTO_NUMBER + 1)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getRandomNumbers(int count) {
        return LOTTO_NUMBERS_CACHE
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    public void shuffle(Consumer<List<LottoNumber>> shuffler) {
        shuffler.accept(LOTTO_NUMBERS_CACHE);
    }
}
