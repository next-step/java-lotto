package lotto.model;

import java.util.Collections;
import java.util.List;
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

    public List<Lotto> generate(int price) {
        int count = price / Lotto.PRICE;
        if (count <= 0) {
            throw new IllegalArgumentException("cannot buy any lotto. required >= " + Lotto.PRICE);
        }

        return Stream.generate(this::generate)
                .limit(count)
                .collect(toList());
    }

    private Lotto generate() {
        List<Integer> numbers = Number.all();
        Collections.shuffle(numbers, this.random);

        numbers = numbers.subList(0, Lotto.COUNT);
        return new Lotto(numbers);
    }

}
