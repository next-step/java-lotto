import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

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
