package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyTest {

    @DisplayName("금액이 생성된다.")
    @Test
    void createMoney() {
        Money money = new Money(1000);
        Assertions.assertThat(money).isEqualTo(new Money(1000));
    }

    @DisplayName("금액이 음수일 경우 에러를 반환한다.")
    @Test
    void validateMoneyMinus() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Money(-1000);
                }).withMessageMatching("금액은 음수일 수 없습니다.");
    }

    @DisplayName("1000원 단위가 아닐 경우 에러를 반환한다.")
    @Test
    void validateMoneyUnit() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Money(1500);
                }).withMessageMatching("1000원 단위만 입력 가능합니다.");
    }
}
