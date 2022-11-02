package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoNumberGenerator {
    public static final Random RANDOM = new Random();
    private static final int MAX_LOTTO_NUMBER = 45;
    public static List<LottoNumber> lottoNumbers = IntStream
            .rangeClosed(1,MAX_LOTTO_NUMBER)
            .mapToObj(value -> new LottoNumber(value))
            .collect(Collectors.toList());

    static LottoNumber getRandomNumber() {
        return lottoNumbers.get(RANDOM.nextInt(MAX_LOTTO_NUMBER));
    }
}
