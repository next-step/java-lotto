package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGeneration implements NumberGenerationStrategy {

    @Override
    public Set<LottoNumber> generateNumbers() {

        List<LottoNumber> pool = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(pool);

        return new HashSet<>(pool.subList(0, 6));
    }
}
