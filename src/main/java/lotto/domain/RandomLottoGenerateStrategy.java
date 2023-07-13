package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerateStrategy extends LottoGenerateStrategy {

    public RandomLottoGenerateStrategy() {
        this(Ball.MIN_NUMBER, Ball.MAX_NUMBER);
    }

    public RandomLottoGenerateStrategy(final int minNumber, final int maxNumber) {
        super(minNumber, maxNumber);
    }

    @Override
    public Lotto generate() {
        List<Ball> copied = new ArrayList<>(this.balls);
        Collections.shuffle(copied);
        return new Lotto(copied.subList(0, Lotto.SIZE));
    }
}
