package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,true", "10000,true", "1100,true", "500,false", "0,false"})
    @DisplayName("금액의 최소값은 1000원 이상이다")
    void validatePriceTest(int price, boolean expected) {
        boolean result = ValidationUtils.isValidPrice(price);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "45,true", "0,false", "46,false"})
    @DisplayName("로또 번호는 1 ~ 45 사이의 수이다")
    void validateLottoNumberBoundaryTest(int number, boolean expected) {
        boolean result = ValidationUtils.isValidLottoNumberBoundary(number);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideListForValidLottoLength")
    @DisplayName("로또 번호는 6자리 수이다")
    void validateLottoNumberBoundaryTest(List<Integer> numbers, boolean expected) {
        boolean result = ValidationUtils.isValidLottoNumbersLength(numbers);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideListForValidLottoNotDuplicate")
    @DisplayName("로또 번호는 서로 중복되지 않는다.")
    void validateLottoNumberNotDuplicateTest(List<Integer> numbers, boolean expected) {
        boolean result = ValidationUtils.isNotDuplicateNumbers(numbers);
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> provideListForValidLottoLength() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), true),
                Arguments.of(Collections.emptyList(), false),
                Arguments.of(null, false),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), false),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7), false)
        );
    }

    private static Stream<Arguments> provideListForValidLottoNotDuplicate() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), true),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5), false)
        );
    }
}
