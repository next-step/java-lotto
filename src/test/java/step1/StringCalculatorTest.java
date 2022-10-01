package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    void 여러_숫자_덧셈_테스트(){

        String input = "10 + 10 + 10 + 10 + 10";
        String input2 = "20 + 20 + 20 + 20 + 20";
        String input3 = "10 + 20 + 30 + 40 + 50";

        assertThat(StringCalculator.operate(input)).isEqualTo(50);
        assertThat(StringCalculator.operate(input2)).isEqualTo(100);
        assertThat(StringCalculator.operate(input3)).isEqualTo(150);
    }

    @Test
    void 여러_숫자_뺄셈_테스트(){

        String input = "100 - 3 - 3 - 4 - 4";
        String input2 = "50 - 2 - 3";

        assertThat(StringCalculator.operate(input)).isEqualTo(86);
        assertThat(StringCalculator.operate(input2)).isEqualTo(45);
    }

    @Test
    void 여러_숫자_곱셈_테스트(){

        String input = "100 * 3 * 3 * 4 * 4 * 0";
        String input2 = "50 * 2 * 4";

        assertThat(StringCalculator.operate(input)).isEqualTo(0);
        assertThat(StringCalculator.operate(input2)).isEqualTo(400);
    }

    @Test
    void 여러_숫자_나눗셈_테스트(){
        String input = "100 / 2 / 5 / 3";
        String input0 = "100 / 2 / 5 / 0";

        assertThat(StringCalculator.operate(input)).isEqualTo(3);
        assertThatThrownBy(() -> StringCalculator.operate(input0))
                .isInstanceOf(IllegalArgumentException.class)
                ;
    }

    @Test
    void 여러_숫자_사칙연산_테스트(){
        String input = "2 + 3 * 4 / 2";
        assertThat(StringCalculator.operate(input)).isEqualTo(10);
    }

    @Test
    void 잘못된_사칙연산_검증_테스트(){
        String input = "1 / 4 + 10 ( 4";
        assertThatThrownBy(() -> StringCalculator.operate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 사칙연산이 포함되어 있습니다.");
        ;
    }

    @Test
    void 빈값_검증_테스트(){
        assertThatThrownBy(() -> StringCalculator.operate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null이나 빈 값은 입력할 수 없습니다.");
        ;

        assertThatThrownBy(() -> StringCalculator.operate("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null이나 빈 값은 입력할 수 없습니다.");
        ;

        assertThatThrownBy(() -> StringCalculator.operate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null이나 빈 값은 입력할 수 없습니다.");
        ;
    }

}
