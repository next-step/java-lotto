package lotto.step4.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Fixture {
    static class TestLotto extends Lotto {
        public TestLotto(Set<Integer> lotto) {
            super(lotto);
        }

        public static Lotto of(Integer... numbers) {
            return new Lotto(Arrays.stream(numbers).collect(Collectors.toSet()));
        }
    }

    public static LottoStrategy lottoStrategyFake = new LottoStrategy() {
        @Override
        public Lotto createLotto() {
            return TestLotto.of(1, 2, 3, 4, 5, 6);
        }
    };
}
