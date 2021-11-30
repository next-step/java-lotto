package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(int matchCount, boolean bonusContained, Prize result) {
        // given
        Prize prize = Prize.of(matchCount, bonusContained);

        // then
        assertThat(prize).isEqualTo(result);
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(6, true, FIRST),
                Arguments.of(6, false, FIRST),
                Arguments.of(5, true, SECOND),
                Arguments.of(5, false, THIRD),
                Arguments.of(4, true, FOURTH),
                Arguments.of(4, false, FOURTH),
                Arguments.of(3, true, FIFTH),
                Arguments.of(3, false, FIFTH),
                Arguments.of(2, true, NONE),
                Arguments.of(2, false, NONE),
                Arguments.of(1, true, NONE),
                Arguments.of(1, false, NONE),
                Arguments.of(0, true, NONE),
                Arguments.of(0, false, NONE)
        );
    }
}
