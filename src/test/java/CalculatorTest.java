import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(a+b).isEqualTo(14);
    }
}
