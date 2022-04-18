package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("돈을 생성한다")
    void createMoney() {
        //given, when
        Money money = new Money(1000);

        //then
        assertThat(money.getValue()).isEqualTo(1000);
    }

    @Test
    @DisplayName("음수를 입력하면 예외를 발생한다")
    void failValidation() {
        assertThatThrownBy(() -> new Money(-1)).isInstanceOf(IllegalArgumentException.class);
    }

}