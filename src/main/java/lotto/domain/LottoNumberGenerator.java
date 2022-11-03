package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoNumberGenerator {
    public static final Random RANDOM = new Random();
    private static final int MAX_LOTTO_NUMBER = 45;

    public static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        lottoNumbers = IntStream.rangeClosed(1, MAX_LOTTO_NUMBER)
                .mapToObj(value -> new LottoNumber(value))
                .collect(Collectors.toMap(LottoNumber::getNumber, LottoNumber::getLottoNumber));
    }

    static LottoNumber getRandomNumber() {
        return lottoNumbers.get(RANDOM.nextInt(MAX_LOTTO_NUMBER) + 1);
    }

    static LottoNumber getNumber(int number) {
        return lottoNumbers.get(number);
    }
}
