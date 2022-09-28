package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class NumberTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 이거나 빈 문자열이 입력되면 에러")
    void null_or_empty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

    @Test
    @DisplayName("공백 문자열이 입력되면 에러")
    void blank() {
        String input = "  ";
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "&", "`", "?", "😀"})
    @DisplayName("숫자가 아닌 문자가 입력되면 에러")
    void not_number(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Number(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 123, -123, 0, -1})
    @DisplayName("숫자가 입력되면 정상")
    void normal_number(int input) {
        Number number = new Number(String.valueOf(input));
        assertThat(number.getValue()).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "-1,1", "0,0" ,"100,0"})
    @DisplayName("더하기")
    void add(int x, int y) {
        //given
        Number numberX = new Number(String.valueOf(x));
        Number numberY = new Number(String.valueOf(y));
        //when
        Number addResult = numberX.add(numberY);
        //then
        assertThat(addResult.getValue()).isEqualTo(x+y);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "1,-1", "-1,-1" ,"-1,1"})
    @DisplayName("빼기")
    void substract(int x, int y) {
        //given
        Number numberX = new Number(String.valueOf(x));
        Number numberY = new Number(String.valueOf(y));
        //when
        Number addResult = numberX.subtract(numberY);
        //then
        assertThat(addResult.getValue()).isEqualTo(x-y);
    }

    @ParameterizedTest
    @CsvSource({"1,1", "-1,1", "100,0" ,"-1,-1"})
    @DisplayName("곱하기")
    void multiply(int x, int y) {
        //given
        Number numberX = new Number(String.valueOf(x));
        Number numberY = new Number(String.valueOf(y));
        //when
        Number addResult = numberX.multiply(numberY);
        //then
        assertThat(addResult.getValue()).isEqualTo(x*y);
    }
    @ParameterizedTest
    @CsvSource({"1,1", "-1,1", "10,3" ,"1,-1"})
    @DisplayName("나누기")
    void divide(int x, int y) {
        //given
        Number numberX = new Number(String.valueOf(x));
        Number numberY = new Number(String.valueOf(y));
        //when
        Number addResult = numberX.divide(numberY);
        //then
        assertThat(addResult.getValue()).isEqualTo(x/y);
    }

    @Test
    @DisplayName("분자가 0일때 나누기 에러")
    void divide_zero() {
        //given
        Number numberX = new Number(String.valueOf(1));
        Number numberY = new Number(String.valueOf(0));
        //then
        assertThatThrownBy(() -> numberX.divide(numberY))
                .isInstanceOf(ArithmeticException.class);
    }
}