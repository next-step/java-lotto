package lotto.domain;

import java.util.*;

public class LottoNumberGenerator {
    public static final Random RANDOM = new Random();
    static LottoNumber getRandomNumber() {
        return new LottoNumber(RANDOM.nextInt(45) + 1);
    }
}
