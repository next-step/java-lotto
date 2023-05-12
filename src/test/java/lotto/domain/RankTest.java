package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RankTest {
    @ParameterizedTest
    @CsvSource(value = {"MISS:0", "FIFTH:5000", "FOURTH:50000", "THIRD:1500000", "SECOND:30000000", "FIRST:2000000000"}, delimiter = ':')
    void getMoney(String name, long money) {
        assertThat(Rank.valueOf(name).getMoney()).isEqualTo(new Money(money));
    }

    @ParameterizedTest
    @MethodSource("hasBonus")
    void of(long count, boolean hasBonus, Rank output) {
        assertThat(Rank.of(count, hasBonus)).isEqualTo(output);
    }


    private static Stream<Arguments> hasBonus() {
        return Stream.of(
                Arguments.of(0L, false, Rank.MISS),
                Arguments.of(3L, false, Rank.FIFTH),
                Arguments.of(4L, false, Rank.FOURTH),
                Arguments.of(5L, false, Rank.THIRD),
                Arguments.of(5L, true, Rank.SECOND),
                Arguments.of(6L, false, Rank.FIRST)
        );
    }

}