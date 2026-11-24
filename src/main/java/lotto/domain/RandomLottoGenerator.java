package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final List<Integer> CANDIDATES =
            IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER).boxed().toList();

    @Override
    public Lotto generate() {
        List<Integer> shuffled = new ArrayList<>(CANDIDATES);
        Collections.shuffle(shuffled);
        return new Lotto(shuffled.subList(0, Lotto.LOTTO_SIZE));
    }
}
