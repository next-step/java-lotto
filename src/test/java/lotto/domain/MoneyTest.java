package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("로또 구입가능 여부를 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"2000,true", "1000,false"})
    void isPossibleBuyLotto(int amount, boolean expected) {
        // given
        Money money = Money.from(amount);

        // when
        money.buyLotto();

        // then
        assertThat(money.isPossibleBuyLotto()).isEqualTo(expected);
    }

    @Test
    void validate_최소금액_검증() {
        assertThatThrownBy(() -> Money.from(900))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void validate_유효하지않은_금액_검증() {
        assertThatThrownBy(() -> Money.from(1100))
                .isInstanceOf(RuntimeException.class);
    }
}
