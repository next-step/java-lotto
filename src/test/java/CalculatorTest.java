import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 입력값이_null_또는_빈_공백은_에러() {
        Assertions.assertThatThrownBy(() -> new Calculator(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
