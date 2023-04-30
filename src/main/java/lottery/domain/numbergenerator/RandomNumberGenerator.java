package lottery.domain.numbergenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_BOUND = 45;
    private static final Random RANDOM = new Random();

    @Override
    public int generatedNumber() {
        return RANDOM.nextInt(RANDOM_BOUND) + 1;
    }
}
