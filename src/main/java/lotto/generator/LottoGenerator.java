package lotto.generator;

import java.util.Random;

public class LottoGenerator implements RandomNumberGenerator {

    @Override
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(45) + 1;
    }
}
