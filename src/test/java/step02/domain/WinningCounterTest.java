package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinningCounterTest {

    @DisplayName("특정 수가 몇개 있는지를 가지는 객체를 생성")
    @Test
    public void test_NumberCount_Constructor() {
        assertThat(WinningCounter.of(0, 10)).isEqualTo(WinningCounter.of(0, 10));
    }

    private static Stream<Arguments> provideNumberCountRangeResult() {
        return Stream.of(
                Arguments.of(WinningCounter.of(0, 7), false),
                Arguments.of(WinningCounter.of(1, 5), false),
                Arguments.of(WinningCounter.of(2, 1), false),
                Arguments.of(WinningCounter.of(3, 1), true)
        );
    }

    @DisplayName("number 가 범위 이내에 있는지 boolean 반환")
    @ParameterizedTest
    @MethodSource("provideNumberCountRangeResult")
    public void test_isInRange(WinningCounter winningCounter, boolean expect) {
        assertThat(winningCounter.filter(3, 6)).isEqualTo(expect);
    }
}
