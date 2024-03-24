package domain.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @DisplayName("양수의 금액만 입력하여 생성할 수 있다.")
    @Test
    void create() {
        assertThat(Money.from(1000L)).isEqualTo(new Money(1000L));
    }

    @DisplayName("음수의 금액을 입력하면 예외를 던진다.")
    @Test
    void createWithException() {
        assertThatThrownBy(() -> Money.from(-1000L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("String 형식의 금액을 Money로 만들 수 있다.")
    @Test
    void createWithStringMoney() {
        assertThat(Money.from("1000"))
                .isEqualTo(new Money(1000L));
    }

    @DisplayName("비어있는 문자인 경우 예외를 던진다.")
    @Test
    void createWithExceptionWhenBlankString() {
        assertThatThrownBy(() -> Money.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("소숫점까지 금액 수익률을 나눌 수 있다.")
    @Test
    void divideToDouble() {
        Money money = new Money(14000L);
        double result = money.divideDoubleMoneyToStringResult(new Money(5000L));
        assertThat(result).isEqualTo(0.35);
    }
}
