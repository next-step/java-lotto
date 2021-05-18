package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberTest {

    @DisplayName("숫자를 관리하는 InputNumber 일급컬렉션 생성 테스트")
    @Test
    public void createNumberTest() {
        int number = 1;

        InputNumber inputNumber = InputNumber.create(number);

        assertThat(inputNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("InputNumber 가 음수일때 익셉션 테스트")
    @Test
    public void negativeNumberTest() {
        int inputNumber = -1;

        assertThatThrownBy(() ->
                InputNumber.create(inputNumber)
        ).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("InputNumber 의 더하기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "2:3:5", "0:1:1"}, delimiter = ':')
    public void addNumberTest(int firstNumber, int secondNumber, int totalNumber) {

        InputNumber number = InputNumber.create(firstNumber);
        InputNumber addNumber = InputNumber.create(secondNumber);

        number.add(addNumber);

        assertThat(number.getNumber()).isEqualTo(totalNumber);
    }
}
