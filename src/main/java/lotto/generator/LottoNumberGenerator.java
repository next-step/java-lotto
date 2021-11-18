package lotto.generator;

import java.util.Random;

public class LottoNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(45) + 1;
    }


}
