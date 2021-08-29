package lotto.gameresult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("손익 테스트")
class GainTest {

    private static Stream<Arguments> provideGainDecidedByProfitRate() {
        return Stream.of(
                Arguments.of(0.9, Gain.LOSS),
                Arguments.of(1.0, Gain.BREAK_EVEN_POINT),
                Arguments.of(1.1, Gain.GAIN)
        );
    }

    @ParameterizedTest(name = "수익률 {0}: 결과는 {1}")
    @MethodSource("provideGainDecidedByProfitRate")
    void name(double profitRate, Gain gain) {
        assertThat(Gain.status(profitRate)).isEqualTo(gain);
    }
}
