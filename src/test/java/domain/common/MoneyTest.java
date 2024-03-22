package domain.common;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("양수의 금액만 입력하여 생성할 수 있다.")
    @Test
    void create() {
        assertThat(Money.create(1000L)).isEqualTo(new Money(1000L));
    }

    @DisplayName("음수의 금액을 입력하면 예외를 던진다.")
    @Test
    void createWithException() {
        assertThatThrownBy(() -> Money.create(-1000L))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
