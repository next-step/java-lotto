package lotto.step2.utils;

import lotto.step2.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoUtilsTest {

    @DisplayName("6개의 숫자로 구성 안되서 에러처리")
    @ParameterizedTest
    @MethodSource("provideWrongNumberArray")
    void 숫자구성_6개_실패(int[] input) {

        Set<Integer> numbers = new TreeSet<>(Arrays.stream(input)
                .boxed()
                .collect(Collectors.toSet()));

        assertThatThrownBy(() -> {
            LottoUtils.validation(numbers);
        }).isInstanceOf(LottoException.class)
                .hasMessage("로또는 6개의 숫자로 이루어져야 합니다.");
    }

    private static Stream<Arguments> provideWrongNumberArray() {
        return Stream.of(
                Arguments.of(new int[]{7}),
                Arguments.of(new int[]{1, 3}),
                Arguments.of(new int[]{21, 33, 34}),
                Arguments.of(new int[]{1, 3, 5, 7}),
                Arguments.of(new int[]{5, 10, 13, 17, 29})
        );
    }
}
