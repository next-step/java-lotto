package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

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
}
