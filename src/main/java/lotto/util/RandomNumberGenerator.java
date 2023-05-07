package lotto.util;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Integer RANDOM_MAX = 43;
    private static final Random random = ThreadLocalRandom.current();

    @Override
    public int generate() {
        int randomNumber = random.nextInt(RANDOM_MAX) + 1;
        if (randomNumber > RANDOM_MAX) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        return randomNumber;
    }

}
