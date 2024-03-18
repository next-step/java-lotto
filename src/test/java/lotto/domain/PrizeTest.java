package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

    @ParameterizedTest
    @MethodSource(value = "fromTestSources")
    @DisplayName("보너스/당첨 번호 당첨 개수에 따라 적절한 Prize를 반환한다")
    void from(int matchingCount, boolean matchedBonus, Prize expected) {
        Prize prize = Prize.from(matchingCount, matchedBonus);
        assertThat(prize).isSameAs(expected);
    }

    private static Stream<Arguments> fromTestSources() {
        return Stream.of(
            Arguments.of(0, true, Prize.NONE),
            Arguments.of(0, false, Prize.NONE),
            Arguments.of(1, true, Prize.NONE),
            Arguments.of(1, false, Prize.NONE),
            Arguments.of(2, true, Prize.NONE),
            Arguments.of(2, false, Prize.NONE),
            Arguments.of(3, true, Prize.FIFTH_PLACE),
            Arguments.of(3, false, Prize.FIFTH_PLACE),
            Arguments.of(4, true, Prize.FOURTH_PLACE),
            Arguments.of(4, false, Prize.FOURTH_PLACE),
            Arguments.of(5, true, Prize.SECOND_PLACE),
            Arguments.of(5, false, Prize.THIRD_PLACE),
            Arguments.of(6, true, Prize.FIRST_PLACE),
            Arguments.of(6, false, Prize.FIRST_PLACE)
        );
    }
}
