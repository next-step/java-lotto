package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @Test
    void createMoney() {
        Money money = new Money(1000);
        Assertions.assertThat(money).isEqualTo(new Money(1000));
    }

    @DisplayName("금액이 음수일 경우 에러를 반환한다.")
    @Test
    void validateMoney() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Money(-1000);
                });
    }
}
