package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    public static Lottos generateAutoLottos(long size) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < size; i++) {
            lottos.add(generateAutoLotto());
        }

        return lottos;
    }

    public static Lotto generateAutoLotto() {
        Collections.shuffle(NUMBERS);
        return new Lotto(NUMBERS.subList(0, 6));
    }
}
