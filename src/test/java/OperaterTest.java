import operation.Operater;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperaterTest {

    @Test
    @DisplayName("숫자와 연산자 나누기")
    void divide_number_and_operation() {
        // given
        String numberAndOperation = "3 + 2 + 5 * 10 / 10";
        Operater operater = Operater.defaultOf(numberAndOperation);

        // when
        int result = operater.calculate();

        // then
        Assertions.assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("null 예외 처리")
    void null_operation() {
        // given
        String numberAndOperation = null;

        // then
        assertThrows(IllegalArgumentException.class, () -> Operater.defaultOf(numberAndOperation));
    }

    @Test
    @DisplayName("숫자가 모자란 경우")
    void less_than_two_operation() {
        // given
        String numberAndOperation = "3 + ";

        // then
        assertThrows(IllegalArgumentException.class, () -> Operater.defaultOf(numberAndOperation));
    }

}
