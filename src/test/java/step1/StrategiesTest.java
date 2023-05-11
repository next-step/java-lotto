package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step1.CalculateStratety.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static step1.Sign.*;

class StrategiesTest {

    String ex = "2 + 3 * 4 / 2";
    StringCalculator calculator = new StringCalculator();
    Formula formula = new Formula(ex);

    @Test
    void 사칙연산_기호_X() {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> {
                    calculator.calculate(new Formula("1 _ 1"));
                }).withMessageMatching("사칙연산 기호가 아닙니다.");
    }

    @ParameterizedTest(name = "{0} partner is {1}")
    @MethodSource("parameter")
    void 사칙연산에_맞는_구현체(String sign, CalculateStrategy cs) {
        Strategies strategies = new Strategies();
        assertThat(strategies.getStrategy(sign)).isInstanceOf(cs.getClass());
    }

    static Stream<Arguments> parameter(){
        return Stream.of(
                arguments(PLUS.getSign(),new Plus())
                ,arguments(MINUS.getSign(),new Minus())
                ,arguments(MULTI.getSign(),new Multi())
                ,arguments(DIVIDE.getSign(),new Divide())
        );
    }

}