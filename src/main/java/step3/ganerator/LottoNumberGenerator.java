package step3.ganerator;

import java.util.Random;

public class LottoNumberGenerator implements RandomGenerator{

    private final Random random = new Random();

    @Override
    public int randomNum() {
        return random.nextInt(45) + 1;
    }
}
