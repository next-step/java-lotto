package lotto.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizeTest {

    @DisplayName("일치하는 개수에 맞는 Prize 객체를 반환")
    @ParameterizedTest
    @MethodSource
    void matchedPrize(final int matchedCount, final Prize expected) {
        assertThat(Prize.of(matchedCount)).isEqualTo(expected);
    }

    private static Stream<Arguments> matchedPrize() {
        return Stream.of(
                Arguments.of(0, Prize.MISS),
                Arguments.of(3, Prize.FIFTH),
                Arguments.of(4, Prize.FOURTH),
                Arguments.of(5, Prize.THIRD),
                Arguments.of(6, Prize.FIRST)
        );
    }

    @DisplayName("음수 또는 상금에 포함되지 않는 일치하는 개수인 경우 예외 반환")
    @ParameterizedTest
    @ValueSource(ints = { -1, 7 })
    void matchedPrizeFailure(final int matchedCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> Prize.of(matchedCount));
    }
}
