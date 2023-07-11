package lotto.domain;

import java.util.List;

public class SequenceLottoGenerateStrategy implements LottoGenerateStrategy {

    private int lastNumberIndex = 0;

    @Override
    public Lotto generate(List<Ball> balls) {
        if (lastNumberIndex + Lotto.SIZE > Ball.MAX_NUMBER) {
            lastNumberIndex = 0;
        }
        Lotto lotto = new Lotto(balls.subList(lastNumberIndex, lastNumberIndex + Lotto.SIZE));
        lastNumberIndex += Lotto.SIZE;
        return lotto;
    }
}
