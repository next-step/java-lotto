package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatchingCountTest {
    @DisplayName("일치하는 번호의 갯수가 같다면 true 를 리턴하고 아니라면 false 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("isSet")
    void is(MatchingCount count, int countOfMatch, boolean needBonusNumber, boolean expected) {
        assertThat(count.is(countOfMatch, needBonusNumber)).isEqualTo(expected);
    }
    
    private static Stream<Arguments> isSet() {
        return Stream.of(
                Arguments.arguments(
                        new MatchingCount(6, false),
                        6, false, true
                ),
                Arguments.arguments(
                        new MatchingCount(6, false),
                        5, false, false
                ),
                Arguments.arguments(
                        new MatchingCount(2, false),
                        2, true, false
                )
        );
    }
}
