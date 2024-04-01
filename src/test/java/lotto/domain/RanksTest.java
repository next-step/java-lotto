package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RanksTest {

    @DisplayName("로또 당첨 갯수 세기")
    @ParameterizedTest
    @MethodSource("generateData")
    void count_matching_lottos_test(Lottos lottos, Set<Integer> winningNo) {
        Ranks ranks = new Ranks();
        ranks.countMatchingLottos(lottos, winningNo);

        assertThat(ranks.of().size()).isEqualTo(4);
        assertEquals(1, ranks.of().stream()
                .filter(rank -> rank.getMatchingNumberCount() == Reward.THREE.getMatchingCount())
                .findFirst()
                .orElseThrow()
                .getMatchingLottosCount());

        assertEquals(1, ranks.of().stream()
                .filter(rank -> rank.getMatchingNumberCount() == Reward.FOUR.getMatchingCount())
                .findFirst()
                .orElseThrow()
                .getMatchingLottosCount());

        assertEquals(2, ranks.of().stream()
                .filter(rank -> rank.getMatchingNumberCount() == Reward.FIVE.getMatchingCount())
                .findFirst()
                .orElseThrow()
                .getMatchingLottosCount());

        assertEquals(0, ranks.of().stream()
                .filter(rank -> rank.getMatchingNumberCount() == Reward.SIX.getMatchingCount())
                .findFirst()
                .orElseThrow()
                .getMatchingLottosCount());

    }

    static Stream<Arguments> generateData() {
        Lotto lotto1 = new Lotto(Set.of(1, 2, 3, 10, 20, 30));
        Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 4, 20, 30));
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 44, 13));
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 44, 23));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        Set<Integer> winningNo = Set.of(1, 2, 3, 4, 44, 45);
        return Stream.of(
                Arguments.of(lottos, winningNo)
        );
    }


}
