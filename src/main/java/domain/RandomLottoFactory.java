package domain;

import java.util.Random;

public class RandomLottoFactory implements LottoFactory {

    @Override
    public Lotto create() {
        return Lotto.randomLotto(new Random());
    }
}
