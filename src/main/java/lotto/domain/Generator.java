package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.Price.LOTTO_PRICE;

public class Generator {
    private final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    public Lottos run(int inputPrice) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < inputPrice / LOTTO_PRICE; i++) {
            lottos.add(makeLotto());
        }
        return new Lottos(lottos);
    }

    public Lotto makeLotto() {
        Collections.shuffle(NUMBERS);
        return new Lotto(NUMBERS.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
