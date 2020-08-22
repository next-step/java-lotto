package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("1000원 미만 금액 입력시 예외발생 테스트")
    void money_lack_exception() {
        assertThatThrownBy(() -> new Money(500))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatCode(() -> new Money(1000))
                .doesNotThrowAnyException();
    }

}