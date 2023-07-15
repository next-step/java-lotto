package lotto.domain;

import java.util.List;

public class SequenceLottoGenerateStrategy implements LottoGenerateStrategy {

    private int sequenceStartIndex = 0;

    @Override
    public Lotto generate(final List<Ball> balls) {
        if (sequenceStartIndex + Lotto.SIZE > Ball.MAX_NUMBER) {
            sequenceStartIndex = 0;
        }

        Lotto lotto = new Lotto(balls.subList(sequenceStartIndex, sequenceStartIndex + Lotto.SIZE));

        sequenceStartIndex += Lotto.SIZE;

        return lotto;
    }
}
