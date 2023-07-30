package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerateStrategy implements LottoGenerateStrategy {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final List<Ball> LOTTO_BALLS = IntStream.range(MIN_LOTTO_NUM, MAX_LOTTO_NUM + 1)
            .mapToObj(Ball::new)
            .collect(Collectors.toList());

    @Override
    public Lotto generate() {
        List<Ball> copied = new ArrayList<>(LOTTO_BALLS);

        Collections.shuffle(copied);

        return new Lotto(copied.subList(0, Lotto.SIZE));
    }
}
