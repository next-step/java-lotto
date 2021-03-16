package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("돈은 1000원 단위여야한다.")
    @Test
    void money() {
        Assertions.assertThatThrownBy(() -> {
            new Money(900);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("1000원 단위로 돈을 지불해주세요");
    }
}