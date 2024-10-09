package calculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    @DisplayName("getOperators는 size가 4인 배열을 반환한다.")
    void 메소드_반환값_4() {
         assertThat(Operator.getOperators()).hasSize(4);
    }

}