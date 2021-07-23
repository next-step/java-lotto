package lotto.prize;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 당첨 결과 클래스 테스트")
class MatchResultTest {

    @DisplayName("당첨 결과는 처음 지불한 금액과 상금 매치 결과를 가지고 초기화 한다.")
    @Test
    void initMatchResult() {
        int payment = 10_000;
        Map<LottoPrize, Integer> matchResult = Collections.emptyMap();

        assertThat(MatchResult.init(payment, matchResult)).isInstanceOf(MatchResult.class);
    }

    @DisplayName("당첨 결과중 지불 금액과 매치 결과는 null 일 수 없다.")
    @MethodSource
    @ParameterizedTest
    void initException(int payment, Map<LottoPrize, Integer> matchResult) {
        assertThatThrownBy(() -> MatchResult.init(payment, matchResult)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initException() {
        return Stream.of(
                Arguments.of(-1, Collections.emptyMap()),
                Arguments.of(1, null),
                Arguments.of(-1, null)
        );
    }

}
