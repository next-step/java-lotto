package lotto.generator;

import java.util.Random;

public class LottoNumberGenerator implements NumberGenerator {

    public int generate(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber) + 1;
    }
}
