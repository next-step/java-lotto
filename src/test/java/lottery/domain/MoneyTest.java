package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("돈 생성 테스트")
    void moneyTest(){
        final Money money = new Money(1000);

        assertThat(money.amount()).isEqualTo(1000);

        assertThatThrownBy(() -> {
            new Money(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 필수 입니다.");

        assertThatThrownBy(() -> {
            new Money(1500);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1000 단위 입니다.");
    }

    @Test
    @DisplayName("돈 차감 테스트")
    void decreaseTest(){
        final Money money = new Money(1000);

        money.decrease(1000);

        assertThat(money.amount()).isZero();

        assertThatThrownBy(() -> {
            money.decrease(1000);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액이 부족합니다.");
    }

    @Test
    @DisplayName("돈 0 테스트")
    void isZeroTest(){
        final Money money = new Money(0);

        assertThat(money.isZero()).isTrue();
    }
}
