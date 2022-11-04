package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    @DisplayName("더하기")
    void test1() {
        // given
        Money money1 = Money.of(5);
        Money money2 = Money.of(2);
        // when
        Money money = money1.plus(money2);
        // then
        assertThat(money).isEqualTo(Money.of(7));
    }

    @Test
    @DisplayName("빼기")
    void test2() {
        // given
        Money money1 = Money.of(5);
        Money money2 = Money.of(2);
        // when
        Money money = money1.minus(money2);
        // then
        assertThat(money).isEqualTo(Money.of(3));
    }

    @Test
    @DisplayName("빼기 결과가 음수")
    void test3() {
        // given
        Money money1 = Money.of(2);
        Money money2 = Money.of(5);
        // when
        // then
        assertThatThrownBy(() -> {
            money1.minus(money2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("나누기")
    void test4() {
        // given
        Money money1 = Money.of(5);
        Money money2 = Money.of(2);
        // when
        int count = money1.countBy(money2);
        // then
        assertThat(count).isEqualTo(2);
    }

    @Test
    @DisplayName("곱하기")
    void test5() {
        // given
        Money money1 = Money.of(5);
        int count = 2;
        // when
        Money money = money1.multiplyBy(count);
        // then
        assertThat(money).isEqualTo(Money.of(10));
    }

    @Test
    @DisplayName("수익률")
    void test6() {
        // given
        Money money1 = Money.of(10);
        Money money2 = Money.of(5);
        // when
        double earningRate = money1.earningRate(money2);
        // then
        assertThat(earningRate).isEqualTo(2D);
    }

}
