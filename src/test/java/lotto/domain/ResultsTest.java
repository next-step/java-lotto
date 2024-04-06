package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultsTest {

    @DisplayName("로또 당첨 갯수 세기")
    @ParameterizedTest
    @MethodSource("generateData")
    void count_matching_lottos_test(Lottos lottos, Lotto winningLotto) {
        Results result = new Results();
        result.countMatchingLottos(lottos, winningLotto);

        assertEquals(4, result.of().size());
        assertEquals(1, result.of().get(Reward.THREE));
        assertEquals(1, result.of().get(Reward.FOUR));
        assertEquals(2, result.of().get(Reward.FIVE));
        assertEquals(0, result.of().get(Reward.SIX));

    }

    static Stream<Arguments> generateData() {
        Lotto lotto1 = new Lotto(Set.of(1, 2, 3, 10, 20, 30));
        Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 4, 20, 30));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 44, 13));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 44, 23));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        Lotto winningNo = new Lotto(Set.of(1, 2, 3, 4, 44, 45));
        return Stream.of(
                Arguments.of(lottos, winningNo)
        );
    }

}
