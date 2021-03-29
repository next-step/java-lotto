package lotto.domain.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatcherTest {

    @DisplayName("매치카운트에 맞춰서 상금 잘 가져오는지 체크")
    @ParameterizedTest
    @MethodSource("provideLottoMatcher")
    void getWinningBonusTest(long input, Rank expected) {
        assertThat(Rank.match(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoMatcher() {
        return Stream.of(
                Arguments.of(1L, Rank.MISS),
                Arguments.of(3L, Rank.FIFTH),
                Arguments.of(4L, Rank.FOURTH),
                Arguments.of(5L, Rank.THIRD),
                Arguments.of(6L, Rank.FIRST)
        );
    }
}
