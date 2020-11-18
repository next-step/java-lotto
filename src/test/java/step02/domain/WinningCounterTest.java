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

    private static Stream<Arguments> provideWinningNumberIsSameResult() {
        return Stream.of(
                Arguments.of(WinningCounter.of(0, 7), false),
                Arguments.of(WinningCounter.of(1, 5), false),
                Arguments.of(WinningCounter.of(2, 1), false),
                Arguments.of(WinningCounter.of(3, 1), true)
        );
    }

    @DisplayName("입력된 정수와 winningCounter 의 number 가 같은지 비교")
    @ParameterizedTest
    @MethodSource("provideWinningNumberIsSameResult")
    public void test_isSame(WinningCounter winningCounter, boolean expect) {
        assertThat(winningCounter.isSame(3))
                .isEqualTo(expect);
    }
}
