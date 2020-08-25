package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", "1,2,3,4,5,6"),
                Arguments.of("2,3,4,5,6,7", "2,3,4,5,6"),
                Arguments.of("10,24,26,32,27,1", "1")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("번호(Number)가 6개의 다른 값이 아니면 예외를 반환한다.")
    void numbersExceptionTest(String input) {
        String[] split = input.split(",");
        Set<Number> collect = Arrays.stream(split)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toCollection(TreeSet::new));
        assertThatThrownBy(() -> new LottoNumbers(collect))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("자신이 가진 로또 번호와 제공된 로또 번호에서 일치하는 번호 리스트를 제공한다.")
    void getContainNumbersTest(String input, String expectedInput) {
        Set<Number> numbers = makeInputToNumbers(input);
        Set<Number> winningNumbers = makeInputToNumbers("1,2,3,4,5,6");

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningNumbers);

        Set<Number> actual = lottoNumbers.getContainNumbers(winningLottoNumbers);

        Set<Number> expected = makeInputToNumbers(expectedInput);

        assertThat(actual).isEqualTo(expected);
    }

    private Set<Number> makeInputToNumbers(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Test
    @DisplayName("자신이 가진 로또 번호가 보너스 숫자를 포함하는지 결과값 제공")
    void isContainBonusTest() {
        Set<Number> numbers = makeInputToNumbers("1,2,3,4,5,6");
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        Number bonusNumber = new Number(6);

        assertThat(lottoNumbers.isContainBonus(bonusNumber)).isTrue();
    }

}