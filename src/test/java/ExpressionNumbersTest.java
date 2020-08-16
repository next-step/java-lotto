import common.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionNumbersTest {
    @DisplayName("숫자값들 저장 객체 생성")
    @Test
    void newInstance() {
        //given
        String[] values = {"1", "2"};

        //when
        ExpressionNumbers expressionNumbers = ExpressionNumbers.newInstance(values);

        //then
        assertThat(expressionNumbers).isNotNull();
    }

    @DisplayName("숫자값들 저장 객체 생성 - 비정상값 에러발생")
    @Test
    void newInstanceWithWrongValues() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ExpressionNumbers.newInstance(null))
                .withMessage(ExceptionMessage.WRONG_NUMBER.printMessage());
    }

    @DisplayName("숫자들의 합을 구한다")
    @Test
    void sum() {
        //given
        String[] values = {"1", "2", "3"};
        ExpressionNumbers expressionNumbers = ExpressionNumbers.newInstance(values);

        //when
        ExpressionNumber actual = expressionNumbers.sum();
        //then
        ExpressionNumber expected = ExpressionNumber.newInstance("6");
        assertEquals(expected, actual);
    }
}
