package lotto.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 당첨 enum 테스트")
class LottoPrizeTest {

    @DisplayName("당첨된 갯수를 넘겨주면 해당하는 등수를 반환한다.")
    @MethodSource
    @ParameterizedTest
    void getPrizeByMatchCount(int matchCount, LottoPrize expectedLottoPrize) {
        assertThat(LottoPrize.of(matchCount)).isEqualTo(expectedLottoPrize);
    }

    private static Stream<Arguments> getPrizeByMatchCount() {
        return Stream.of(
                Arguments.of(6, LottoPrize.FIRST),
                Arguments.of(5, LottoPrize.SECOND),
                Arguments.of(4, LottoPrize.THIRD),
                Arguments.of(3, LottoPrize.FOURTH),
                Arguments.of(2, LottoPrize.FIFTH),
                Arguments.of(1, LottoPrize.NONE),
                Arguments.of(0, LottoPrize.NONE)
        );
    }
}
