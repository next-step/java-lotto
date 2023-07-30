package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequenceLottoGenerateStrategy implements LottoGenerateStrategy {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final List<Ball> LOTTO_BALLS = IntStream.range(MIN_LOTTO_NUM, MAX_LOTTO_NUM + 1)
            .mapToObj(Ball::new)
            .collect(Collectors.toList());

    private int sequenceStartIndex = 0;

    @Override
    public Lotto generate() {
        if (sequenceStartIndex + Lotto.SIZE > Ball.MAX_NUMBER) {
            sequenceStartIndex = 0;
        }

        Lotto lotto = new Lotto(LOTTO_BALLS.subList(sequenceStartIndex, sequenceStartIndex + Lotto.SIZE));

        sequenceStartIndex += Lotto.SIZE;

        return lotto;
    }
}
