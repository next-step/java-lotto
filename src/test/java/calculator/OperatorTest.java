package calculator;

import calculator.model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @DisplayName("잘못된 문자열 연산자 예외 테스트")
    @ValueSource(strings = {
            "//",
            "^",
            "2"
    })
    void 연산자_생성_예외_테스트(String operator){
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    Operator.of(operator);
                });

    }

    @ParameterizedTest
    @DisplayName("연산자 계산 테스트")
    @CsvSource({
            "+, 8",
            "-, 4",
            "*, 12",
            "/, 3"
    })
    void 연산자_계산_테스트(String op, int res){
        Operator operator = Operator.of(op);
        assertThat(operator.calculate(6, 2)).isEqualTo(res);
    }





}
