package lotto.gameresult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("손익 테스트")
class GainTest {

    @DisplayName("수익률이")
    @ParameterizedTest(name = "{0}/{1}: 결과는 {2}")
    @MethodSource("provideGainDecidedByProfitRate")
    void name(int prizeMoney, int payments, Gain expected) {
        Gain actual = Gain.status(new ProfitRate(prizeMoney, payments));
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideGainDecidedByProfitRate() {
        return Stream.of(
                Arguments.of(9, 10, Gain.LOSS),
                Arguments.of(10, 10, Gain.BREAK_EVEN_POINT),
                Arguments.of(11, 10, Gain.GAIN)
        );
    }
}
