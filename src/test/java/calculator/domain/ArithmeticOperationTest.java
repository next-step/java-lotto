package calculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticOperationTest {
    @ParameterizedTest
    @CsvSource(value = {"+,true", "-,true", "*,true","/,true","a,false"})
    void 사칙연산_기호_체크(String sign, boolean expected) {
        assertThat(ArithmeticOperation.hasOperation(sign)).isEqualTo(expected);
    }

    @Test
    void 사칙연산_기호에_따라_계산이_달라진다() {
        assertThat(ArithmeticOperation.getOperation("+").getClass()).isEqualTo(PlusOperationImpl.class);
        assertThat(ArithmeticOperation.getOperation("-").getClass()).isEqualTo(MinusOperationImpl.class);
        assertThat(ArithmeticOperation.getOperation("*").getClass()).isEqualTo(MultipleOperationImpl.class);
        assertThat(ArithmeticOperation.getOperation("/").getClass()).isEqualTo(DivisionOperationImpl.class);
    }
}
