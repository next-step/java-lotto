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
    void getWinningBonusTest(long input, LottoMatcher expected) {
        assertThat(LottoMatcher.match(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoMatcher() {
        return Stream.of(
                Arguments.of(1L, LottoMatcher.MATCH_ZERO),
                Arguments.of(3L, LottoMatcher.MATCH_THREE),
                Arguments.of(4L, LottoMatcher.MATCH_FOUR),
                Arguments.of(5L, LottoMatcher.MATCH_FIVE),
                Arguments.of(6L, LottoMatcher.MATCH_SIX)
        );
    }
}
