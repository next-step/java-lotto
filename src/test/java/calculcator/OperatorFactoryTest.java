package calculcator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorFactoryTest {


    @DisplayName("사칙연산 부호가 아닐시 에러 체크")
    @Test
    void create() {
        assertThatThrownBy(()->OperatorFactory.create("k")).isInstanceOf(IllegalArgumentException.class);
    }
}