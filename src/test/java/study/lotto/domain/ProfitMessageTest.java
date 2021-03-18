package study.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.lotto.domain.type.ProfitMessage;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitMessageTest {

    private static Stream<Arguments> profitEntry() {
        return Stream.of(
                Arguments.of(1.5, ProfitMessage.PROFIT),
                Arguments.of(1.0, ProfitMessage.BREAK_POINT),
                Arguments.of(0.5, ProfitMessage.LOSS)
        );
    }

    @ParameterizedTest(name = "{0} 값 계산 시 결과 -> {1}")
    @MethodSource(value = "profitEntry")
    void test(double given, ProfitMessage expected) {
        // given

        // when
        ProfitMessage msg = ProfitMessage.of(given);
        // then
        assertThat(msg).isEqualTo(expected);
    }
}
