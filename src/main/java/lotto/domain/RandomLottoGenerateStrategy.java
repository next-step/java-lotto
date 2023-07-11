package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomLottoGenerateStrategy implements LottoGenerateStrategy {

    @Override
    public Lotto generate(final List<Ball> balls) {
        Collections.shuffle(balls);
        return new Lotto(balls.subList(0, Lotto.SIZE));
    }
}
