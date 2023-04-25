package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumberTest {

    @Test
    @DisplayName("1~45 사이의 정수 입력시 정상수행됩니다.")
    void test01() {
        List<Integer> passList = List.of(1, 2, 3, 4, 5, 6);
        assertThatNoException().isThrownBy(() -> new LottoWinningNumber(passList));
    }

    private static Stream<Arguments> provideArgumentsForZeroOrNegativeNumberTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), "중복숫자가 포함된 리스트"),
                Arguments.of(List.of(1, 2, 0, 4, 5, 6), "0이 포함된 리스트"),
                Arguments.of(List.of(1, 2, 3, 4, 5, -6), "음수가 포함된 리스트")
        );
    }

    @ParameterizedTest(name = "input={0} -> {1}")
    @MethodSource("provideArgumentsForZeroOrNegativeNumberTest")
    @DisplayName("0 또는 음수가 존재할경우 에러가 발생합니다.")
    void test03(List<Integer> list, String desc) {
        assertThatThrownBy(() -> new LottoWinningNumber(list))
                .isInstanceOf(IllegalArgumentException.class);
    }

}