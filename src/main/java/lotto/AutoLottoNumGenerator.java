package lotto;

import java.util.Random;

public class AutoLottoNumGenerator implements LottoNumGenerator {

    private final Random random = new Random();

    @Override
    public int generateNum() {
        return random.nextInt(45) + 1;
    }
}
