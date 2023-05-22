package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @ParameterizedTest
    @MethodSource("매칭볼과_보너스볼_매칭되는_순위_페어")
    void 매칭볼과_보너스볼_매칭되는_순위를_반환한다(int matchingCount, boolean bonusBallMatch, Prize prize) {
        assertThat(Prize.valueOf(matchingCount, bonusBallMatch)).isEqualTo(prize);
    }

    static Stream<Arguments> 매칭볼과_보너스볼_매칭되는_순위_페어() {
        return Stream.of(
                Arguments.arguments(6, false, Prize.FIRST_PLACE),
                Arguments.arguments(5, true, Prize.SECOND_PLACE),
                Arguments.arguments(5, false, Prize.THIRD_PLACE),
                Arguments.arguments(4, false, Prize.FOURTH_PLACE),
                Arguments.arguments(3, false, Prize.FIFTH_PLACE)
        );
    }
}