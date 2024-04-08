package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProfitTest {

    @DisplayName("수익률 구하기")
    @ParameterizedTest
    @MethodSource("generateData")
    void profit_rate_test(Results ranks, Lottos autoLottos) {
        Profit profit = new Profit(ranks, autoLottos);

        assertEquals(763.75, profit.getProfitRate());
    }

    static Stream<Arguments> generateData() {
        Lotto lotto1 = new Lotto(Set.of(1, 2, 3, 10, 20, 30));
        Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 4, 20, 30));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 44, 13));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 44, 23));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));

        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        result.put(Rank.FIFTH, 1);
        result.put(Rank.FOURTH, 1);
        result.put(Rank.THIRD, 2);
        result.put(Rank.FIRST, 0);

        Results ranks = new Results(result);

        return Stream.of(
                Arguments.of(ranks, lottos)
        );
    }

}
