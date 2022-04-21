package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @ParameterizedTest(name = "일치하는 숫자 개수를 통해 상금을 조회한다.")
    @MethodSource("provideMatchCounts")
    void findEarningsByMatchCount(int matchCount, double earnings) {
        assertThat(Prize.findEarningsByMatchCount(matchCount))
                .isEqualTo(earnings);
    }

    private static Stream<Arguments> provideMatchCounts() {
        return Stream.of(
                Arguments.of(0, 0d),
                Arguments.of(1, 0d),
                Arguments.of(2, 0d),
                Arguments.of(3, 5000d),
                Arguments.of(4, 50000d),
                Arguments.of(5, 1_500_000d),
                Arguments.of(6, 2_000_000_000d)
        );
    }

    @ParameterizedTest(name = "0에서 6까지의 숫자로만 상긍을 조회할 수 있다.")
    @ValueSource(ints = {-1, 7})
    void findEarningsByMatchCount_Exception(int invalidMatchCount) {
        assertThatThrownBy(() -> Prize.findEarningsByMatchCount(invalidMatchCount))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void getMatchCounts() {
        assertThat(Prize.getMatchCounts())
                .containsExactly(0, 1, 2, 3, 4, 5, 6);
    }
}