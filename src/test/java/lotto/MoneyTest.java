package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = 500)
    @DisplayName("최소 금액 입력하지 않았을 때")
    public void minimumPriceCheck(int price) {
        assertThatThrownBy(() -> new Money(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또의 최소 금액은 1000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = 10000)
    @DisplayName("로또 몇 개 샀는지")
    public void getLottoCount(int price) {
        Money money = new Money(price);
        assertThat(money.getLottoCount()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(ints = 10000)
    @DisplayName("로또 가격 가져오는지")
    public void getLottoPrice(int price) {
        Money money = new Money(price);
        assertThat(money.getLottoPrice()).isEqualTo(price);
    }

}
