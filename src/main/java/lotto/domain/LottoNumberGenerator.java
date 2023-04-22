package lotto.domain;

import java.util.concurrent.ThreadLocalRandom;

public class LottoNumberGenerator {
    private static final int RANDOM_NUMBER_MINIMUM = 1;
    private static final int RANDOM_NUMBER_MAXIMUM = 45;

    // TODO: 추후 객체생성이 불필요하면 클래스 메서드로 변경
    public int generate() {
        return ThreadLocalRandom
                .current()
                .nextInt(RANDOM_NUMBER_MINIMUM, RANDOM_NUMBER_MAXIMUM + 1);
    }
}