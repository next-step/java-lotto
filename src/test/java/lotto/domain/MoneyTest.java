package lotto.domain;

import static lotto.domain.Money.CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION;
import static lotto.domain.Money.MONEY_TO_GO_BACK_EXCEPTION;
import static lotto.domain.Money.NEGATIVE_NUMBER_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @Test
    @DisplayName("돈이 음수이면 예외를 던진다.")
    void minus_money_exception() {
        // given
        long money = -1;

        // when // then
        assertThatThrownBy(() -> new Money(money))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_NUMBER_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("돈으로 로또를 살 수 없으면 예외를 던진다.")
    @ValueSource(longs = {999, 0})
    void cannot_buy_one_lotto(long given) {
        // when  // then
        assertThatThrownBy(() -> new Money(given))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("거슬러줄 돈이 있으면 예외를 던진다.")
    @ValueSource(longs = {3300, 1100, 1001})
    void money_to_go_back_exception(long given) {
        // when  // then
        assertThatThrownBy(() -> new Money(given))
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(MONEY_TO_GO_BACK_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("돈으로 몇 개의 로또를 살 수 있는지 알려준다.")
    @CsvSource(value = {"3000, 3", "1000, 1"})
    void change_to_lotto_count(long given, long expected) {
        // given
        Money money = new Money(given);

        // when
        long result = money.lottoQuantity();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동으로 구매할 로또 갯수를 알려준다.")
    void inform_automatic_purchased_lotto_count() {
        // given
        Money money = new Money(14000);

        // when
        long result = money.calculateAutomaticLottoCount(3);

        // then
        assertThat(result).isEqualTo(11);
    }
}
