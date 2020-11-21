package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class AddCalculatorTest {

    private final AddCalculator addCalculator = new AddCalculator();

    @ParameterizedTest
    @DisplayName("빈 문자열을 입력할 경우 0을 반환해야 한다")
    @ValueSource(strings = {"", " "})
    void should_return_zero_when_is_blank(String value) {
        //Given & When
        int result = addCalculator.calculate(value);

        //Then
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("null 값을 입력할 경우 0을 반환해야 한다")
    void should_return_zero_when_is_null() {
        //Given & When
        int result = addCalculator.calculate(null);

        //Then
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void should_return_a_number() {
        //Given & When
        int result = addCalculator.calculate("1");

        //Then
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("구분자를 컴마(,),콜론(:) 또는  \"//\"와 \"\n\" 문자 사이에 커스텀 구분자를 지정하여, 합을 구한다.")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3", "//;\n1;2;3"})
    void should_return_sum_of_three_numbers(String value) {
        //Given & When
        int result = addCalculator.calculate(value);

        //Then
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @DisplayName("음수를 전달할 경우 IllegalArgumentException 예외가 발생해야 한다")
    @ValueSource(strings = {"-1,-2,3", "1,-2,2"})
    void should_throw_illegal_argument_exception(String value) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> addCalculator.calculate(value))
                .withMessage("not allow negative quantity");
    }


}
