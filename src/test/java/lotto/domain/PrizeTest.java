package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {
    @DisplayName("일치하는 갯수에 해당하는 상을 리턴한다.")
    @ParameterizedTest
    @MethodSource("prizeSet")
    void get(int matchCount, Prize expected) {
        assertThat(Prize.get(matchCount)).isEqualTo(expected);
    }
    
    private static Stream<Arguments> prizeSet() {
        return Stream.of(
                Arguments.arguments(0, Prize.NO_PRIZE),
                Arguments.arguments(1, Prize.NO_PRIZE),
                Arguments.arguments(2, Prize.NO_PRIZE),
                Arguments.arguments(3, Prize.FOURTH),
                Arguments.arguments(4, Prize.THIRD),
                Arguments.arguments(5, Prize.SECOND),
                Arguments.arguments(6, Prize.FIRST),
                Arguments.arguments(7, Prize.NO_PRIZE)
        );
    }
}
