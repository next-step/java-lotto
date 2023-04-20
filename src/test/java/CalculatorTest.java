import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2!", "2 + 3 * 4 ^ 2"})
    @DisplayName("입력받은_문자열_예외처리_테스트")
    public void 입력받은_문자열_예외처리_테스트(String formula){
        assertThatIllegalArgumentException().isThrownBy(()->{
            Calculator.calculate(formula);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ", })
    @DisplayName("입력받음 문자열 null&blank 테스트")
    public void NullAndBlankTest(String formula){
        assertThatIllegalArgumentException().isThrownBy(()->{
            Calculator.calculate(formula);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "1 * 2 / 3 - 4:-4"}, delimiter = ':')
    @DisplayName("계산_테스트")
    public void 계산_테스트(String formula, int expected){

        int result = Calculator.calculate(formula);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("덧셈_테스트")
    public void 덧셈_테스트(){
        //given
        int a = 4;
        int b = 10;

        //when
        int result = Calculator.add(a,b);

        //then
        assertThat(result).isEqualTo(14);
    }

    @Test
    @DisplayName("뺃셈_테스트")
    public void 뺃셈_테스트(){
        //given
        int a = 4;
        int b = 10;
        //when
        int result = Calculator.subtraction(a,b);

        //then
        assertThat(result).isEqualTo(-6);
    }

    @Test
    @DisplayName("곱셈_테스트")
    public void 곱셈_테스트(){
        //given
        int a = 4;
        int b = 10;
        //when
        int result = Calculator.multiplication(a,b);
        //then
        assertThat(result).isEqualTo(40);
    }

    @Test
    @DisplayName("나눗셈_테스트")
    public void 나눗셈_테스트(){
        //given
        int a = 10;
        int b = 2;
        //when
        int result = Calculator.division(a,b);
        //then
        assertThat(result).isEqualTo(5);
    }
}
