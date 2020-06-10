package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningNumbersTest {

    Set<Integer> winningNumbers;

    @BeforeEach
    void setUp(){
        winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("당첨 번호 수가 안 맞는 경우 예외발생")
    @ParameterizedTest
    @MethodSource("listProvider")
    void numbersSizeTest(Set<Integer> numbers){
        assertThatThrownBy(() -> WinningNumbers.of(numbers, 9))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))),
                arguments(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5))),
                arguments(new HashSet<>(Collections.emptyList()))
        );
    }

    @DisplayName("보너스볼 번호가 1 ~ 45 사이가 아닌 경우 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void bonusNumberBoundaryTest(int bonusNumber){
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 보너스볼 중복시 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void containsTest(int bonusNumber) {
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}