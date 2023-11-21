package lotto.domain;

import static lotto.domain.Money.CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION;
import static lotto.domain.Money.MONEY_TO_GO_BACK_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @DisplayName("돈으로 몇 개의 로또를 살 수 있는지 알려준다.")
    @CsvSource(value = {"3000, 3", "1000, 1"})
    void change_to_lotto_cnt(long given, long expected) {
        // given
        Money money = new Money(given);

        // when
        long result = money.lottoQuantity();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("돈으로 로또를 살 수 없으면 예외를 던진다.")
    @ValueSource(longs = {999, 0})
    void cannot_buy_one_lotto(long given) {
        // given
        Money money = new Money(given);

        // when  // then
        assertThatThrownBy(() -> money.lottoQuantity())
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(CANNOT_BUY_EVEN_ONLY_ONE_LOTTO_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("거슬러줄 돈이 있으면 예외를 던진다.")
    @ValueSource(longs = {3300, 1100, 1001})
    void money_to_go_back_exception(long given) {
        // given
        Money money = new Money(given);

        // when  // then
        assertThatThrownBy(() -> money.lottoQuantity())
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(MONEY_TO_GO_BACK_EXCEPTION);
    }
}
