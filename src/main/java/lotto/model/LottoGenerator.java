package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {
    private final Random random;

    public LottoGenerator() {
        this.random = new Random();
    }

    public LottoGenerator(Random random) {
        this.random = random;
    }

    public Lottos generate(Count count) {
        Objects.requireNonNull(count);
        
        List<Lotto> lottos = Stream.generate(this::generate)
                .limit(count.value())
                .collect(toList());

        return Lottos.of(lottos);
    }

    private Lotto generate() {
        List<Integer> numbers = Number.all();
        Collections.shuffle(numbers, this.random);

        numbers = numbers.subList(0, Lotto.COUNT);
        return new Lotto(numbers);
    }

}
