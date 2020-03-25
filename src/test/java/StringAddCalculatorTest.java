import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @DisplayName("null 또는 공백이 입력되면 true를 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmptyTest(String input) {
        assertThat(StringAddCalculator.isNullOrEmpty(input)).isTrue();
    }

    @DisplayName("기본 구분자로 구분된 문자열을 입력하면, 숫자로 간주되는 문자열의 갯수를 가진 콜렉션이 리턴된다.")
    @ParameterizedTest
    @CsvSource(value = {"2,4,5=3", "23:4=2", "2,24,20:1,5=5"}, delimiter = '=')
    void extractStringNumberTest(String input, int expected) {
        assertThat(StringAddCalculator.splitByDefault(input).size()).isEqualTo(expected);
    }

    @DisplayName("숫자 이외의 값이 입력되면 예외를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,@,3", "10,2,3:=", "%,),2:*"})
    void convertToNumberTest(String input) {
        //given
        List<String> stringNumbers = StringAddCalculator.splitByDefault(input);

        //when, then
        assertThatThrownBy(() -> {
            StringAddCalculator.covertToNumber(stringNumbers);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("음수를 입력하면 예외를 리턴한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,-1,0", "10,-9", "20,-20,-1"})
    void validateNegativeTest(String input) {
        //given
        List<String> stringNumbers = StringAddCalculator.splitByDefault(input);
        List<Integer> numbers = StringAddCalculator.covertToNumber(stringNumbers);

        //when, then
        assertThatThrownBy(() -> {
            StringAddCalculator.validateNegative(numbers);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자로 변환된 콜렉션을 주면, 합(sum)을 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,2,4=6", "7,3,1,23,5=39", "1,2:5,34:3=45"}, delimiter = '=')
    void sumTest(String input, int expected) {
        //given
        List<String> strings = StringAddCalculator.splitByDefault(input);
        List<Integer> integers = StringAddCalculator.covertToNumber(strings);

        //when
        int sum = StringAddCalculator.sum(integers);

        //then
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("null 또는 공백 문자열이 입력되면 0을 리턴한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void addStringTestWhenNullOrEmpty(String input) {
        //when, then
        int sum = StringAddCalculator.addString(input);

        //then
        assertThat(sum).isZero();
    }

}