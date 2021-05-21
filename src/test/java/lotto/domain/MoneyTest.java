package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("1000원 단위로 입력하지않으면 예외가 발생한다")
    @Test
    void validate_money_exception() {
        assertThatThrownBy(() -> Money.from(14100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 1000원 단위로 구입 가능합니다.");
    }

    @DisplayName("로또 구입이 가능하면 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1000,1,false", "1000,0,true"})
    void possible_buy_lotto(int amount, int count, boolean expected) {
        // given
        Money money = Money.from(amount);

        // when
        boolean isPossibleBuyLotto = money.isPossibleBuyLotto(count);

        // then
        assertThat(isPossibleBuyLotto).isEqualTo(expected);
    }
}
