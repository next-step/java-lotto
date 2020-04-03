package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;


class MoneyTest {

    private Money thousand;

    @BeforeEach
    void setUp() {
        thousand = Money.of(1000);
    }

    @Test
    @DisplayName("Money 생성 및 equals 테스트")
    void successByCreation() {
        assertThat(thousand).isEqualTo(Money.of(1000));
    }

    @Test
    @DisplayName("Money를 Money로 나누면 count 반환")
    void divide() {
        Money hundred = Money.of(99);
        assertThat(thousand.divide(hundred)).isEqualTo(10);
    }

    @Test
    @DisplayName("Money에 count를 곱하면 Money 반환")
    void mulitply() {
        assertThat(thousand.multiply(10)).isEqualTo(Money.of(10000));
    }

    @Test
    @DisplayName("이익률 계산")
    void calculateProfit() {
        Money totalAmount = Money.of(200000);
        BigDecimal profitRate = totalAmount.calculateProfit(thousand);
        assertThat(profitRate).isEqualTo(new BigDecimal("200.00"));

        profitRate = totalAmount.calculateProfit(Money.of(30));
        assertThat(profitRate).isEqualTo(new BigDecimal("6666.67"));
    }
}