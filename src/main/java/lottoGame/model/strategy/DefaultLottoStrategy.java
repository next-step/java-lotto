package lottoGame.model.strategy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class DefaultLottoStrategy implements LottoStrategy {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LIMIT = 6;

    @Override
    public List<Integer> createLottoNum() {
        return ThreadLocalRandom.current()
                .ints(MIN, MAX)
                .distinct()
                .limit(LIMIT)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }
}
