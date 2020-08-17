package stringcalculator.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.common.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionNumberTest {
    @DisplayName("숫자 생성 - 0 이상 숫자")
    @Test
    void newInstance() {
        String numberValue = "0";
        ExpressionNumber expressionNumber = ExpressionNumber.newInstance(numberValue);

        //then
        assertThat(expressionNumber).isNotNull();
    }

    @DisplayName("숫자 생성 - 음수이거나 잘못된 값인 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "", "#"})
    void newInstanceWithWrongValue(String numberValue) {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> ExpressionNumber.newInstance(numberValue))
                .withMessage(ExceptionMessage.WRONG_NUMBER.printMessage());
    }

    @DisplayName("숫자를 더하고 객체를 반환한다.")
    @Test
    void add() {
        //given
        String x = "1";
        String y = "2";

        ExpressionNumber number1 = ExpressionNumber.newInstance(x);
        ExpressionNumber number2 = ExpressionNumber.newInstance(y);

        //when
        ExpressionNumber actual = number1.add(number2);

        //then
        ExpressionNumber expected = ExpressionNumber.newInstance("3");
        assertEquals(expected, actual);
    }
}
