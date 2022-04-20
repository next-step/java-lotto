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

    @Test
    @DisplayName("돈의 합을 계산한다")
    void add() {
        //given
        Money money1 = new Money(2000);
        Money money2 = new Money(1000);

        //when
        Money result = money1.add(money2);

        //then
        assertThat(result).isEqualTo(new Money(3000));
    }

    @Test
    @DisplayName("돈의 곱를 계산한다")
    void multiply() {
        //given
        Money money = new Money(2000);

        //when
        Money result = money.multiply(3);

        //then
        assertThat(result).isEqualTo(new Money(6000));
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide() {
        //given
        Money cost = new Money(2000);
        Money principal = new Money(50000);

        //when
        double profitRatio = cost.divide(principal);

        //then
        assertThat(profitRatio).isEqualTo(0.04);
    }
}