package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class MatchTest {
    @ParameterizedTest
    @CsvSource(value = {"NONE:0", "THREE:5000", "FOUR:50000", "FIVE:1500000", "SIX:2000000000"}, delimiter = ':')
    void getMoney(String name, long money) {
        assertThat(Match.valueOf(name).getMoney()).isEqualTo(new Money(money));
    }

    @ParameterizedTest
    @MethodSource("ofArguments")
    void of(long input, Match output) {
        assertThat(Match.of(input)).isEqualTo(output);
    }

    private static Stream<Arguments> ofArguments() {
        return Stream.of(
                Arguments.of(0L, Match.NONE),
                Arguments.of(3L, Match.THREE),
                Arguments.of(4L, Match.FOUR),
                Arguments.of(5L, Match.FIVE),
                Arguments.of(6L, Match.SIX)
        );
    }

}