package lotto.step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Fixture {
    public static Lotto l1 = TestLotto.of(1, 2, 3, 4, 5, 7);
    public static List<Lotto> lottosList = List.of(l1);

    public static Set<Integer> winningNumber = Set.of(1, 2, 3, 4, 5, 6);
    public static final int bonusNumber = 7;

    static class TestLotto extends Lotto {
        public TestLotto(Set<Integer> lotto) {
            super(lotto);
        }

        public static Lotto of(Integer... numbers) {
            return new Lotto(Arrays.stream(numbers).collect(Collectors.toSet()));
        }
    }
}
