package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    static final String ERROR_NUMBER_NAME = "가";
    static final String NORMAL_NUMBER = "3";

    @Test
    @DisplayName("숫자가 아닌 생성에 대한 에러처리")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> new Number(ERROR_NUMBER_NAME)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("정상적인 숫자로 생성자 테스트")
    public void constructorSuccessTest() {
        assertThat(new Number(NORMAL_NUMBER)).isEqualTo(new Number(NORMAL_NUMBER));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3"
    })
    @DisplayName("연산 더하기에 대한 테스트")
    public void NumberPlusTest(String left, String right, String result) {
        assertThat(new Number(left).plus(new Number(right))).isEqualTo(new Number(result));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "3,2,1"
    })
    @DisplayName("연산 빼기에 대한 테스트")
    public void NumberMinusTest(String left, String right, String result) {
        assertThat(new Number(left).minus(new Number(right))).isEqualTo(new Number(result));
    }


    @ParameterizedTest
    @CsvSource(value = {
            "1,2,2"
    })
    @DisplayName("연산 곱하기에 대한 테스트")
    public void NumberMultiplyTest(String left, String right, String result) {
        assertThat(new Number(left).multiply(new Number(right))).isEqualTo(new Number(result));
    }


    @ParameterizedTest
    @CsvSource(value = {
            "2,1,2"
    })
    @DisplayName("연산 나누기에 대한 테스트")
    public void NumberDivideTest(String left, String right, String result) {
        assertThat(new Number(left).divide(new Number(right))).isEqualTo(new Number(result));
    }
}