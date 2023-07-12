package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoGenerateStrategy implements LottoGenerateStrategy {

    @Override
    public Lotto generate(final List<Ball> balls) {
        List<Ball> copied = new ArrayList<>(balls);

        Collections.shuffle(copied);

        return new Lotto(copied.subList(0, Lotto.SIZE));
    }
}
