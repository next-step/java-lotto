package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.Prize.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @ParameterizedTest
    @MethodSource("constructorMethodSource")
    @DisplayName("각 등수에 대한 정보를 static 하게 사용할 수 있다.")
    void constructorMethod(Prize self, int hitCount, int money) {
        assertThat(self.hitCount()).isEqualTo(hitCount);
        assertThat(self.money()).isEqualTo(money);
    }

    static Stream<Arguments> constructorMethodSource() {
        return Stream.of(
                Arguments.of(FIRST, 6, 20_0000_0000),
                Arguments.of(SECOND, 5, 150_0000),
                Arguments.of(THIRD, 4, 5_0000),
                Arguments.of(FOURTH, 3, 5000),
                Arguments.of(FIFTH, 2, 0),
                Arguments.of(SIXTH, 1, 0),
                Arguments.of(LOSE, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("compareToMethodSource")
    @DisplayName("각 등수는 순서를 갖는다. FIRST 가 가장 크고 LOSE 가 가장 작다.")
    void compareToMethod(Prize self, Prize other) {
        assertThat(self).isGreaterThan(other);
    }

    static Stream<Arguments> compareToMethodSource() {
        return Stream.of(
                Arguments.of(FIRST, SECOND),
                Arguments.of(SECOND, THIRD),
                Arguments.of(THIRD, FOURTH),
                Arguments.of(FOURTH, FIFTH),
                Arguments.of(FIFTH, SIXTH),
                Arguments.of(SIXTH, LOSE)
        );
    }

    @ParameterizedTest
    @MethodSource("ofMethodSource")
    @DisplayName("맞은 번호에 따라 상금을 리턴할 수 있는지")
    void ofMethod(int hitCount, Prize result) {
        assertThat(Prize.of(hitCount)).isEqualTo(result);
    }

    static Stream<Arguments> ofMethodSource() {
        return Stream.of(
                Arguments.of(6, FIRST),
                Arguments.of(5, SECOND),
                Arguments.of(4, THIRD),
                Arguments.of(3, FOURTH),
                Arguments.of(2, FIFTH),
                Arguments.of(1, SIXTH),
                Arguments.of(0, LOSE)
        );
    }
}
