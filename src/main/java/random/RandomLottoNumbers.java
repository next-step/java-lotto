package random;

import java.util.Random;

public class RandomLottoNumbers implements LottoGenerator {
    @Override
    public int executeStrategy() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
