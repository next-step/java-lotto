package lotto.step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private final List<Integer> AUTO_LOTTO = IntStream.rangeClosed(1, 45).mapToObj(Integer::new).collect(Collectors.toList());

    private Lotto() {
    }

    private static class LazyHolder {
        private static final Lotto instance = new Lotto();
    }

    public static Lotto getInstance() {
        return LazyHolder.instance;
    }
}
