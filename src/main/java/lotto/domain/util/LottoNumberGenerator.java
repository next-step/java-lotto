package lotto.domain.util;

import java.util.concurrent.ThreadLocalRandom;

public final class LottoNumberGenerator {

    private static final int RANDOM_NUMBER_MINIMUM = 1;
    private static final int RANDOM_NUMBER_MAXIMUM = 45;

    private LottoNumberGenerator() {
        throw new IllegalCallerException("잘못된 객체 생성 입니다.");
    }

    public static int generate() {
        return ThreadLocalRandom
                .current()
                .nextInt(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM + 1);
    }
}