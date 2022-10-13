package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CashierTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {
        
        @DisplayName("Money 타입을 받는다.")
        @Test
        void createCashier() {
            Cashier expected = new Cashier(new Money("14000"));

            Cashier actual = new Cashier("14000");

            assertThat(actual).isEqualTo(expected);
        }
    }

    @DisplayName("플레이 가능한 로또 수를 가져온다.")
    @Test
    void count_play_lotto() {
        int actual = new Cashier("14000").countPlayLotto();

        assertThat(actual).isEqualTo(14);
    }

    @DisplayName("로또를 사고 남은 돈을 알려준다.")
    @Test
    void remain_money() {
        Money actual = new Cashier("14300").receiveLeftMoney();

        assertThat(actual).isEqualTo(new Money(300));
    }
}
