package com.ssabae.nextstep.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
@SuppressWarnings("NonAsciiCharacters")
class MoneyTest {

    @Test
    @DisplayName("Money 생성 실패 (음수)")
    void shouldBeExceptionWhenGenerateMoneyTest() {
        assertThatThrownBy(() -> Money.won(-1L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Money 더하기 Test")
    void moneyPlusTest() {
        Money 백원 = Money.won(100L);
        Money 이백원 = 백원.plus(백원);

        assertThat(이백원).isEqualTo(Money.won(200L));
    }

    @Test
    @DisplayName("Money 빼기 Test")
    void moneyMinusTest() {
        Money 이백원 = Money.won(200L);
        Money 백원 = 이백원.minus(Money.won(100L));

        assertThat(백원).isEqualTo(Money.won(100L));
    }

    @Test
    @DisplayName("Money 곱하기 Test")
    void moneyTimesTest() {
        Money 백원 = Money.won(100L);
        Money 만원 = 백원.times(100);

        assertThat(만원).isEqualTo(Money.won(10_000L));
    }

    @Test
    @DisplayName("Money 곱하기 Test")
    void longValueEqualsTest() {
        Money 백원 = Money.won(100L);

        assertThat(백원.getAmountLongValue()).isEqualTo(100L);
    }

}
