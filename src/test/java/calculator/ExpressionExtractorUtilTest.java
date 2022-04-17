package calculator;

import calculator.model.Number;
import calculator.model.Operator;
import calculator.util.ExpressionExtractorUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionExtractorUtilTest {

    @Test
    @DisplayName("수식에서 숫자를 추출한다")
    void numberExtractTest() {
        //given,when
        List<Number> numbers = ExpressionExtractorUtil.extractNumbers("2+3-4*2/2");

        //then
        assertThat(numbers).hasSize(5);
    }

    @Test
    @DisplayName("수식에서 연산자를 추출한다")
    void operatorExtractTest() {
        //given, when
        List<Operator> operators = ExpressionExtractorUtil.extractOperators("2+3-4*2/2");

        //then
        assertThat(operators).hasSize(4);
    }

}