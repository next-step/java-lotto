import domain.ArithmeticSign;
import domain.Number;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ArithmeticTest {

    Arithmetic arithmetic = new Arithmetic();

    @Test
    public void 덧셈_expect_success() {
        Number result = arithmetic.doArithmetic(new Number(3), new Number(5), new ArithmeticSign("+"));
        assertThat(result).isEqualTo(new Number(8));
    }


    @Test
    public void 뺄셈_expect_success() {
        Number result = arithmetic.doArithmetic(new Number(7), new Number(3), new ArithmeticSign("-"));
        assertThat(result).isEqualTo(new Number(4));
    }


    @Test
    public void 곱셈_expect_success() {
        Number result = arithmetic.doArithmetic(new Number(5), new Number(9), new ArithmeticSign("*"));
        assertThat(result).isEqualTo(new Number(45));
    }


    @Test
    public void 나눗셈_expect_success() {
        Number result = arithmetic.doArithmetic(new Number(27), new Number(3), new ArithmeticSign("/"));
        assertThat(result).isEqualTo(new Number(9));
    }


    @Test
    public void 나눗셈_0으로_나누기_expect_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> arithmetic.doArithmetic(new Number(8), new Number(0), new ArithmeticSign("/")));
    }

    @Test
    public void 나눗셈_결과_정수아님_expect_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> arithmetic.doArithmetic(new Number(8), new Number(3), new ArithmeticSign("/")));
    }
}
