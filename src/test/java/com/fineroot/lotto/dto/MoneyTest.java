package com.fineroot.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.fineroot.lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @Test
    @DisplayName("Money 생성")
    void create() {
        Money money = Money.from(14000);
        assertThat(money).isInstanceOf(Money.class);
        assertThat(money.getValue()).isEqualTo(14000);
    }

    @Test
    @DisplayName("음수 money 생성 예외 발생")
    void create_Negative_Exception() {
        assertThatThrownBy(() -> Money.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.MONEY_NEGATIVE.getMessage());
    }
}
