import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    @DisplayName("덧셈 계산기")
    void plus() {
        // given
        int first = 2;
        int second = 2;
        // when
        int result = Operation.plus(first, second);
        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("뺄셈 계산기")
    void minus() {
        // given
        int first = 2;
        int second = 2;
        // when
        int result = Operation.minus(first, second);
        // then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("곱셈 계산기")
    void multiply() {
        // given
        int first = 2;
        int second = 2;
        // when
        int result = Operation.multiply(first, second);
        // then
        Assertions.assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("나눗셈 계산기")
    void divide() {
        // given
        int first = 2;
        int second = 2;
        // when
        int result = Operation.divide(first, second);
        // then
        Assertions.assertThat(result).isEqualTo(1);
    }

}
