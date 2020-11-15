package lotto.domain.lotto;

import java.util.Random;

public class CreateRandomNumberStrategy implements CreateLottoNumberStrategy {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public LottoNumber create() {
        final int max = LottoNumber.MAX.getValue();
        final int min = LottoNumber.MIN.getValue();
        final int randomNumber = RANDOM.nextInt(max) + min;
        return LottoNumber.of(randomNumber);
    }
}
