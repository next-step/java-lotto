package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lottery.domain.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    static Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(0, false, LOSING_TICKET),
            Arguments.of(1, false, LOSING_TICKET),
            Arguments.of(2, false, LOSING_TICKET),
            Arguments.of(3, false, FIFTH),
            Arguments.of(4, false, FOURTH),
            Arguments.of(5, false, THIRD),
            Arguments.of(5, true, SECOND),
            Arguments.of(6, false, FIRST)
        );
    }

    @DisplayName("당첨 번호와 일치하는 수의 개수, 보너스 번호 일치 여부로 등수를 알아낸다.")
    @ParameterizedTest(name = "일치하는 번호의 수 - {0}, 보너스 번호 일치 여부 - {1}")
    @MethodSource("generateTestData")
    void getPrize(long matchedCount, boolean bonusNumberMatched, Prize expected) {
        assertThat(Prize.getPrize(matchedCount, bonusNumberMatched)).isEqualTo(expected);
    }
}
