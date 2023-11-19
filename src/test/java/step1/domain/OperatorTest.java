package step1.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorTest {

    @Test
    @DisplayName("올바르지 않은 연산자를 입력하면 실패")
    void operatorTest() {
        String token = "^";
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> Operator.find(token));
    }

}
