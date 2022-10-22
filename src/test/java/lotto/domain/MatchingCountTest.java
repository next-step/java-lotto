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
    @MethodSource("equalsSet")
    void equals(MatchingCount count, MatchingCount other, boolean expected) {
        assertThat(count.equals(other)).isEqualTo(expected);
    }

    @DisplayName("보너스 번호 포함정보가 없다면 false 를 리턴하고 있다면 true 를 리턴한다.")
    @ParameterizedTest
    @MethodSource("hasBonusNumberSet")
    void hasBonusNumber(MatchingCount count, boolean expected) {
        assertThat(count.hasBonusNumber()).isEqualTo(expected);
    }

    private static Stream<Arguments> hasBonusNumberSet() {
        return Stream.of(
                Arguments.arguments(new MatchingCount(5, true), true),
                Arguments.arguments(new MatchingCount(3, false), false),
                Arguments.arguments(new MatchingCount(1), false)
        );
    }
    
    private static Stream<Arguments> equalsSet() {
        return Stream.of(
                Arguments.arguments(
                        new MatchingCount(0, false),
                        new MatchingCount(0, false),
                        true
                ),
                Arguments.arguments(
                        new MatchingCount(6, true),
                        new MatchingCount(6, true),
                        true
                ),
                Arguments.arguments(
                        new MatchingCount(6),
                        new MatchingCount(6, true),
                        true
                ),
                Arguments.arguments(
                        new MatchingCount(6),
                        new MatchingCount(6, false),
                        true
                ),
                Arguments.arguments(
                        new MatchingCount(6, true),
                        new MatchingCount(6, false),
                        false
                ),
                Arguments.arguments(
                        new MatchingCount(1),
                        new MatchingCount(2, false),
                        false
                ),
                Arguments.arguments(
                        new MatchingCount(3),
                        new MatchingCount(4, true),
                        false
                )
        );
    }
}
