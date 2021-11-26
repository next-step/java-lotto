package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MatchTest {

    @DisplayName("matchedCount에 따라 Match enum을 생성하는지 검증")
    @ParameterizedTest
    @MethodSource("fromParameter")
    void fromTest(int matchedCount, Match expected) {
        assertThat(Match.from(matchedCount)).isEqualTo(expected);
    }

    private static Stream<Arguments> fromParameter() {
        return Stream.of(Arguments.of(3, Match.THREE),
                         Arguments.of(4, Match.FOUR),
                         Arguments.of(5, Match.FIVE),
                         Arguments.of(6, Match.SIX));
    }

    @DisplayName("from메서드에 match enum에 맞지 않는 값이 들어오면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 7, 8 })
    void invalidFromTest(int matchedCount) {
        assertThatThrownBy(() -> Match.from(matchedCount)).isInstanceOf(IllegalArgumentException.class);
    }
}
