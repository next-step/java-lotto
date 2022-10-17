package lottoGame.model.strategy;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class DefaultLottoStrategy implements LottoStrategy {
    @Override
    public List<Integer> createLottoNum() {
        return ThreadLocalRandom
                .current()
                .ints(1, 45)
                .distinct()
                .limit(6)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }
}
