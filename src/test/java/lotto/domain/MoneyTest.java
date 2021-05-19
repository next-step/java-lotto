package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("1000원 이상 입력시 금액을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 5000, 10000})
    void createWithValidAmount(final int amount) {
        final Money money = new Money(amount);
        assertThat(money).isNotNull();
    }

    @DisplayName("유효하지 않은 금액 입력시 에러를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 500})
    void createWithInValidAmount(final int amount) {
        assertThatThrownBy(() -> new Money(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매가능한 로또 갯수를 리턴한다.")
    @Test
    void getLottoCount() {
        final Money money = new Money(5500);
        assertThat(money.getLottoCount()).isEqualTo(5);
    }
}
