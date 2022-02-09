package lotto.domain;

import static lotto.domain.WinningResult.FIRST;
import static lotto.domain.WinningResult.SECOND;
import static lotto.domain.WinningResult.THIRD;
import static lotto.domain.WinningResult.FOUR;
import static lotto.domain.WinningResult.FIVE;
import static lotto.domain.WinningResult.NOTHING;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningResultTest {

    private static Stream<Arguments> 로또_당첨시_로또_당첨_결과를_반환한다() {
        return Stream.of(
            Arguments.of(FIRST, 6, false),
            Arguments.of(SECOND, 5, true),
            Arguments.of(THIRD, 5, false),
            Arguments.of(FOUR, 4, false),
            Arguments.of(FIVE, 3, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void 로또_당첨시_로또_당첨_결과를_반환한다(WinningResult winningResult, int matchingCount, boolean matchingBonus) {
        assertThat(winningResult).isEqualTo(WinningResult.getResult(matchingCount, matchingBonus));
    }

    private static Stream<Arguments> 로또_낙첨시_로또_당첨_결과를_반환한다() {
        return Stream.of(
            Arguments.of(2, false),
            Arguments.of(1, false),
            Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void 로또_낙첨시_로또_당첨_결과를_반환한다(int matchingCount, boolean matchingBonus) {
        assertThat(NOTHING).isEqualTo(WinningResult.getResult(matchingCount, matchingBonus));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6})
    void 보너스볼과_관련_없는_당첨시_보너스볼은_결과에_영향을_주지_않는다(int matchingCount) {
        assertThat(WinningResult.getResult(matchingCount, false))
            .isEqualTo(WinningResult.getResult(matchingCount, true));
    }
}
