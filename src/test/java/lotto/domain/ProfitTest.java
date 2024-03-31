package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {

    @DisplayName("수익률 구하기")
    @ParameterizedTest
    @MethodSource("generateData")
    void profit_rate_test(Ranks ranks, Lottos autoLottos) {
        Profit profit = new Profit(ranks, autoLottos);

        assertEquals(profit.getProfitRate(), 763.75);
    }

    static Stream<Arguments> generateData() {
        Lotto lotto1 = new Lotto(Set.of(1, 2, 3, 10, 20, 30));
        Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 4, 20, 30));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 44, 13));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 44, 23));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));

        Set<Rank> rankResult = new HashSet<>(){{
            add(new Rank(Reward.THREE.getMatchingCount(), 1));
            add(new Rank(Reward.FOUR.getMatchingCount(), 1));
            add(new Rank(Reward.FIVE.getMatchingCount(), 2));
            add(new Rank(Reward.SIX.getMatchingCount(), 0));
        }};

        Ranks ranks = new Ranks(rankResult);

        return Stream.of(
                Arguments.of(ranks, lottos)
        );
    }

}
