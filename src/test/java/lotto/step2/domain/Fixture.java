package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Fixture {
    public static Lotto l1 = TestLotto.of(1, 2, 3, 4, 5, 6);
    public static Lotto l2 = TestLotto.of(1, 2, 3, 34, 35, 36);
    public static Lotto l3 = TestLotto.of(4, 5, 6, 7, 8, 9);
    public static List<Lotto> lottosList = List.of(l1, l2, l3);

    public static Set<Integer> winningNumber = Set.of(1, 2, 3, 4, 5, 6);

    static class TestLotto extends Lotto {
        public TestLotto(List<Integer> lotto) {
            super(lotto);
        }

        public static Lotto of(Integer... numbers) {
            return new Lotto(Arrays.stream(numbers).collect(Collectors.toList()));
        }
    }

    public static LottoStrategy lottoStrategyFake = new LottoStrategy() {
        @Override
        public Lotto createLotto() {
            return TestLotto.of(1, 2, 3, 4, 5, 6);
        }
    };
}
