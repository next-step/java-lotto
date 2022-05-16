package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoAutoMachine {

    private static final List<Integer> numberPool = Stream.iterate(1, n -> n + 1).limit(45).collect(Collectors.toList());

    private LottoAutoMachine() {
    }

    public static Lotto makeLotto() {
        Collections.shuffle(numberPool);
        List<Integer> integers = numberPool.subList(0, 6);
        Collections.sort(integers);
        return new Lotto(integers);
    }

    public static Lottos makeLottos(int count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            lottos.addLotto(makeLotto());
        }
        return lottos;
    }
}

