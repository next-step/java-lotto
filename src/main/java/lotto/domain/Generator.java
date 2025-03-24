package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    private final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    public List<Lotto> run(int inputPrice) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < inputPrice / LOTTO_PRICE; i++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    public Lotto makeLotto() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
