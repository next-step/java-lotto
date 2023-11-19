import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperaterTest {

    @Test
    @DisplayName("숫자와 연산자 나누기")
    void divide_number_and_operation() throws Exception {
        // given
        String numberAndOperation = "3 + 2 + 5 * 10 / 10";
        Operater operater = Operater.defaultOf(numberAndOperation);

        // when
        int result = operater.calculate();

        // then
        Assertions.assertThat(result).isEqualTo(10);
    }

}
