package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowableOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringCalculator.domain.expression.operator.impl.OperatorImpl;
import stringCalculator.error.ErrorMessage;

public class CalculatorTest {

    @Test
    @DisplayName("계산기는 숫자 2개가 입력될때 더한값을 반환한다")
    public void Calculator_Should_Return_Sum_When_Two_Numbers_Entered() throws Exception {
        //given
        String input = "+" ;

        //when
        long sum = OperatorImpl.fromOperator(input).calculate(1, 2);

        //then
        assertThat(sum).isEqualTo(3);
    }

    @Test
    @DisplayName("계산기에 음수 2개가 전달될 때 더한 값이 정상적으로 반환되어야 한다")
    public void Calculator_Should_Return_Minus_When_Two_Numbers_Entered() throws Exception {
        //given
        String input = "+" ;

        //when
        long sum = OperatorImpl.fromOperator(input).calculate(-1, -5);

        //then
        assertThat(sum).isEqualTo(-6);
    }

    @Test
    @DisplayName("계산기에 숫자 2개가 덧셈 되었을 때 최대 범위를 검증해야한다")
    public void Maximum_range_should_Be_Verified_When_Two_Numbers_Are_Added() throws Exception {
        //given
        String input = "+" ;

        //when
        long sum1 = OperatorImpl.fromOperator(input).calculate(Long.MAX_VALUE, 0);
        long sum2 = OperatorImpl.fromOperator(input).calculate(Long.MAX_VALUE, 1);

        //then
        assertThat(sum1).isEqualTo(9223372036854775807L);
        assertThat(sum2).isEqualTo(-9223372036854775808L);
    }

    @Test
    @DisplayName("계산기에 숫자 2개가 뺄셈 되었을 때 최대 범위를 검증해야한다")
    public void Calculator_Maximum_range_should_Be_Verified_When_Two_Numbers_Are_Minus()
        throws Exception {
        //given
        String input = "-" ;

        //when
        long sum1 = OperatorImpl.fromOperator(input).calculate(-1, Long.MAX_VALUE);
        long sum2 = OperatorImpl.fromOperator(input).calculate(-2, Long.MAX_VALUE);

        //then
        assertThat(sum1).isEqualTo(-9223372036854775808L);
        assertThat(sum2).isEqualTo(9223372036854775807L);
    }


    @Test
    @DisplayName("계산기는 숫자 2개가 입력될때 곱셈이 가능하다")
    public void Calculator_Should_Multiply_When_Two_Numbers_Are_Entered() throws Exception {
        //given
        String input = "*" ;

        //when
        long sum = OperatorImpl.fromOperator(input).calculate(1, 6);

        //then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("계산기는 숫자 2개가 입력될때 나눗셈이 가능하다")
    public void Calculator_Should_Division() throws Exception {
        //given
        String input = "/" ;

        //when
        long sum = OperatorImpl.fromOperator(input).calculate(5, 1);

        //then
        assertThat(sum).isEqualTo(5);
    }

    @Test
    @DisplayName("나눗셈의 경우 결과 값이 정수로 안 떨어지는 경우 예외 발생.")
    public void Calculator_Should_Occur_Exception_When_Divide_Result_Is_Not_Value_Whole_Number()
        throws Exception {
        //given
        String input = "/" ;

        //when
        ArithmeticException actual = catchThrowableOfType(
            () -> OperatorImpl.fromOperator(input).calculate(5, 2), ArithmeticException.class);

        //then
        assertThat(actual).hasMessageContaining(ErrorMessage.DIVIDE_VALUE_ERROR.getErrorMessage());
    }
}

