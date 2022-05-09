package calculator;

import calculator.model.Number;
import calculator.model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberTest {

    @DisplayName("Number 연산 테스트")
    @ParameterizedTest(name = "{0} , {1}")
    @CsvSource(value = {
            "+ , 12",
            "- , 8",
            "* , 20",
            "/ , 5"
    }, delimiter = ',')
    void 숫자_연산_테스트(String operator, int res){
        Number num = new Number(10);
        assertThat(num.calculate(Operator.of(operator), new Number(2))).isEqualTo(new Number(res));
    }
}
