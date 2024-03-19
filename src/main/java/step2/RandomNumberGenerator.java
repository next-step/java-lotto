package step2;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random random = new Random();

    @Override
    public int generate(int bound) {
        return random.nextInt(bound) + 1;
    }
}
