package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashierTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("돈을 받는다.")
        @Test
        void createCashier() {
            Cashier expected = new Cashier(new Money("14000"));

            Cashier actual = new Cashier("14000");

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("천원 단위의 Money가 아니면 예외가 발생한다.")
        @Test
        void validate_Thousand_money() {
            assertThatThrownBy(() -> new Cashier("999"))
                    .isExactlyInstanceOf(NotThousandUnitsMoneyException.class)
                    .hasMessage("천 단위의 돈이 아닙니다.");
        }
    }

    @DisplayName("플레이 가능한 로또 수를 가져온다.")
    @Test
    void find_count_of_play_lotto() {
        int actual = new Cashier("14000").findCountOfPlayLotto();

        assertThat(actual).isEqualTo(14);
    }
}

