package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void 생성() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 999})
    void 천원미만의_금액은_예외를던진다(int given) {
        assertThatThrownBy(() -> new Money(given))
                .isInstanceOf(InvalidLottoException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2})
    void 로또구매수량은_음수이거나_최대구매수량을_초과_할수없다(int quantity) {
        Money money = new Money(1000);

        assertThatThrownBy(() -> money.assertPurchasable(quantity))
                .isInstanceOf(InvalidLottoException.class);
    }

}
