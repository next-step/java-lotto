package lotto.game;

import lotto.exception.LottoIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("돈을 담은 객체를 생성할 수 있다.")
    @Test
    void create() {

        Money money = new Money(1000);

        assertThat(money).isEqualTo(new Money(1000));
    }

    @DisplayName("음수로 돈을 만들 수 없다.")
    @Test
    void negativeAmountException() {

        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(LottoIllegalArgumentException.class);
    }

    @DisplayName("돈의 총액을 로또 가격으로 나눌 수 있다.")
    @Test
    void divide() {
        Money money = new Money(4500);

        assertThat(money.divideByLottoPrice()).isEqualTo(4);
    }
}
