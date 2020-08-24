package stringcalculator.expression;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.common.ExpressionException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DelimiterTest {
    @DisplayName("객체생성")
    @Test
    void newInstanceWithCustomDelimiter() {
        //given
        String delimiter = "[,:]";

        //when
        Delimiter actual = Delimiter.newInstance(delimiter);

        //then
        Delimiter expected = Delimiter.newInstance();
        assertEquals(expected, actual);
    }

    @DisplayName("구분자로 값을 분리하여 반환")
    @Test
    void splitValuesWithDelimiter() {
        String expression = "1;2";
        String delimiterValue = ";";
        Delimiter delimiter = Delimiter.newInstance(delimiterValue);

        //when
        ExpressionNumbers actual = delimiter.splitValue(expression);

        //then
        String[] numberValues = {"1", "2"};
        ExpressionNumbers expected = ExpressionNumbers.newInstance(numberValues);

        assertEquals(expected, actual);
    }

    @DisplayName("구분자로 값을 분리하여 반환")
    @Test
    void splitValuesWithDelimiterWithWrongValue() {
        String expression = "";
        String delimiterValue = ";";
        Delimiter delimiter = Delimiter.newInstance(delimiterValue);

        //when
        assertThatThrownBy(() -> delimiter.splitValue(expression))
                .isInstanceOf(ExpressionException.class);
    }
}
