package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputNumberTest {


    @ValueSource(strings = "1,2:3")
    @ParameterizedTest(name = "{argumentsWithNames}, :를 기준으로 문자열이 잘 구분되는지 확인한다.")
    void splitTest(String input) {
        InputNumber inputNumber = InputNumber.create(input);
        assertThat(inputNumber).isEqualTo(new InputNumber(Arrays.asList(1, 2, 3)));
    }

    @ParameterizedTest(name = "[arguments] 값이 오면, 빈 List 를 반환한다.")
    @NullAndEmptySource
    void spiltEmptyTest(String input) {
        InputNumber inputNumber = InputNumber.create(input);
        assertThat(inputNumber).isEqualTo(new InputNumber());
    }

    @Test
    @DisplayName(value = "숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    void splitOneStringTest() {
        String input = "1";
        InputNumber inputNumber = InputNumber.create(input);

        assertThat(inputNumber).isEqualTo(new InputNumber(Arrays.asList(1)));
    }

    @ParameterizedTest(name = "[{argumentsWithNames}] 음수 또는 잘못된 값이 들어간 경우, IllegalArgumentException이 반환된다.")
    @ValueSource(strings = {"1,2:-3", "=,1,2:3", "-1:-5/3"})
    void invalidExceptionByInputNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> InputNumber.create(input));
    }

}
