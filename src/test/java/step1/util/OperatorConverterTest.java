package step1.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import step1.domain.AdditionOperator;
import step1.domain.DivisionOperator;
import step1.domain.MultiplicationOperator;
import step1.domain.Operator;
import step1.domain.SubtractionOperator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class OperatorConverterTest {

    @Test
    public void 더하기_문자는_더하기_연산자로_변환한다() {
        Operator actual = OperatorConverter.convert("+");
        assertThat(actual).isInstanceOf(AdditionOperator.class);
    }

    @Test
    public void 빼기_문자는_더하기_연산자로_변환한다() {
        Operator actual = OperatorConverter.convert("-");
        assertThat(actual).isInstanceOf(SubtractionOperator.class);
    }

    @Test
    public void 곱하기_문자는_더하기_연산자로_변환한다() {
        Operator actual = OperatorConverter.convert("*");
        assertThat(actual).isInstanceOf(MultiplicationOperator.class);
    }

    @Test
    public void 나누기_문자는_더하기_연산자로_변환한다() {
        Operator actual = OperatorConverter.convert("/");
        assertThat(actual).isInstanceOf(DivisionOperator.class);
    }

    @Test
    public void 유효하지_않은_연산자의_경우_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            OperatorConverter.convert("%");
        });
    }
}
