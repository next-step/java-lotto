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

    @DisplayName("보너스 당첨된 로또가 없는, 로또 당첨 갯수 세기")
    @ParameterizedTest
    @MethodSource("generateData")
    void count_matching_lottos_test(Lottos lottos) {
        Results result = new Results();
        int notMatchedBonus = 5;
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 44, 45)), new LottoNumber(notMatchedBonus));
        result.countMatchingLottos(lottos, winningLotto);

        assertEquals(6, result.of().size());
        assertEquals(1, result.of().get(Rank.MISS));
        assertEquals(1, result.of().get(Rank.FIFTH));
        assertEquals(1, result.of().get(Rank.FOURTH));
        assertEquals(2, result.of().get(Rank.THIRD));
        assertEquals(0, result.of().get(Rank.SECOND));
        assertEquals(0, result.of().get(Rank.FIRST));
    }

    @DisplayName("보너스 당첨이 있는 경우, 로또 당첨 갯수 세기")
    @ParameterizedTest
    @MethodSource("generateData")
    void count_matching_bonus_lottos_test(Lottos lottos) {
        Results result = new Results();

        int matchedBonus = 23;
        WinningLotto winningLotto = new WinningLotto(new Lotto(Set.of(1, 2, 3, 4, 44, 45)), new LottoNumber(matchedBonus));
        result.countMatchingLottos(lottos, winningLotto);

        assertEquals(6, result.of().size());
        assertEquals(1, result.of().get(Rank.MISS));
        assertEquals(1, result.of().get(Rank.FIFTH));
        assertEquals(1, result.of().get(Rank.FOURTH));
        assertEquals(1, result.of().get(Rank.THIRD));
        assertEquals(1, result.of().get(Rank.SECOND));
        assertEquals(0, result.of().get(Rank.FIRST));
    }

    static Stream<Arguments> generateData() {
        Lotto lotto1 = new Lotto(Set.of(1, 2, 3, 10, 20, 30)); // 3
        Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 4, 20, 30));  // 4
        Lotto lotto3 = new Lotto(Set.of(1, 2, 3, 4, 44, 13));  // 5
        Lotto lotto4 = new Lotto(Set.of(1, 2, 3, 4, 44, 23));  // 5
        Lotto lotto5 = new Lotto(Set.of(21, 22, 23, 24, 25, 26));  // 0
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4, lotto5));
        return Stream.of(
                Arguments.of(lottos)
        );
    }

}
