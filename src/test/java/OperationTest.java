import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    @DisplayName("덧셈 계산기")
    void writingMethodName() throws Exception {
        // given
        int first = 1;
        int second = 2;
        // when
        int result = Operation.plus(first, second);
        // then
        Assertions.assertThat(result).isEqualTo(3);
    }
}
