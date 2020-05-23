package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PrizeTest {

    @DisplayName("일치하는 개수에 맞는 Prize 객체를 반환")
    @ParameterizedTest
    @MethodSource
    void matchedPrize(final int matchedCount, final boolean matchBonus, final Prize expected) {
        assertThat(Prize.of(matchedCount, matchBonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchedPrize() {
        return Stream.of(
                Arguments.of(0, false, Prize.MISS),
                Arguments.of(1, false, Prize.MISS),
                Arguments.of(2, false, Prize.MISS),
                Arguments.of(3, true, Prize.FIFTH),
                Arguments.of(4, false, Prize.FOURTH),
                Arguments.of(5, false, Prize.THIRD),
                Arguments.of(5, true, Prize.SECOND),
                Arguments.of(6, false, Prize.FIRST)
        );
    }

    @DisplayName("1 ~ 6 이내의 일치하는 개수인 경우 예외가 발생")
    @ParameterizedTest
    @ValueSource(ints = { Prize.MIN_MATCHED_COUNT - 1, Prize.MAX_MATCHED_COUNT + 1})
    void matchedPrizeFailure(final int matchedNumbersCount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Prize.of(matchedNumbersCount, false));
    }
}
