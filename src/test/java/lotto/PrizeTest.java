package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @ParameterizedTest
    @MethodSource("ofMethodSource")
    @DisplayName("맞춘개수와 보너스 여부를 판단하여 알맞은 상금을 반환할 수 있다.")
    void ofMethod(int matchCount, boolean hasBonus, Prize result) {
        // given
        Prize self = Prize.of(matchCount, hasBonus);

        // when

        // then
        assertThat(self).isEqualTo(result);
    }

    static Stream<Arguments> ofMethodSource() {
        return Stream.of(
                Arguments.of(0, false, LOSE),
                Arguments.of(0, true, LOSE),
                Arguments.of(1, false, SEVENTH),
                Arguments.of(1, true, SEVENTH),
                Arguments.of(2, false, SIXTH),
                Arguments.of(2, true, SIXTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(4, false, FOURTH),
                Arguments.of(4, true, FOURTH),
                Arguments.of(5, false, THIRD),
                Arguments.of(5, true, SECOND),
                Arguments.of(6, false, FIRST),
                Arguments.of(6, true, FIRST)
        );
    }
}
