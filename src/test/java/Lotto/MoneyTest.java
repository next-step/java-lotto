package Lotto;

import Lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    @DisplayName("입력하는 금액은 반드시 1000원 이상이어야 한다")
    void errorMoneyWhenInputLessThan1000won() {
        assertThatThrownBy(() -> {
            Money.from(900);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("돈을 입력하면 로또의 갯수를 가지고 올 수 있다.")
    void getCountOfLottoWithMoney() {
        final Money money = Money.from(14500);
        assertThat(money.getLottoCount()).isEqualTo(14);
    }
}
