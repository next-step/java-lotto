import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @DisplayName("숫자로 된 문자열을 정수형 타입으로 변환한다.")
    @Test
    public void shouldConvertStringToInt() {
        // given
        String intValue = "1";
        int expectedResult = 1;

        // when
        Number result = Number.ofNumber(intValue);

        // then
        assertThat(result.getAnswer()).isEqualTo(expectedResult);
    }

    @DisplayName("숫자로 된 문자열이 정수형인지 판별한다.")
    @Test
    public void shouldThrowException_whenStringIsNotConvertibleToInt() {
        // given
        String intValue = "일";

        // when & then
        assertThatThrownBy(() -> {
            Number result = Number.ofNumber(intValue);
        }).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("덧셈을 수행한다.")
    @Test
    public void shouldExecuteAddition() {
        // given
        Number number1 = new Number(1);
        Number number2 = new Number(2);
        // when
        number1.add(number2);

        //then
        assertThat(number1.getAnswer()).isEqualTo(3);
    }

    @DisplayName("뺄셈을 수행한다.")
    @Test
    @ValueSource
    public void shouldExecuteSubtraction() {
        // given
        Number number1 = new Number(2);
        Number number2 = new Number(1);
        // when
        number1.subtract(number2);

        //then
        assertThat(number1.getAnswer()).isEqualTo(1);
    }

    @DisplayName("곱셈을 수행한다.")
    @Test
    public void shouldExecuteMultiplication() {
        // given
        Number number1 = new Number(2);
        Number number2 = new Number(3);
        // when
        number1.multiple(number2);

        //then
        assertThat(number1.getAnswer()).isEqualTo(6);
    }

    @DisplayName("나눗셈을 수행한다.")
    @Test
    public void shouldExecuteDivision() {
        // given
        Number number1 = new Number(6);
        Number number2 = new Number(2);
        // when
        number1.divide(number2);

        //then
        assertThat(number1.getAnswer()).isEqualTo(3);
    }
}
