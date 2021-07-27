package lotto.domain;

import lotto.exception.IllegalMoneyNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class MoneyTest {

    @DisplayName("구입 금액은 0보다 큰 1000으로 나누어 떨어지는 수여야 한다.")
    @ParameterizedTest
    @ValueSource(longs = {-10, 100, 100001})
    void money_validation(long number) {
        assertThatThrownBy(() -> Money.of(number))
                .isInstanceOf(IllegalMoneyNumberException.class);
    }

    @DisplayName("구입 금액에 해당하는 만큼 로또 티켓을 구입할 수 있어야 한다.")
    @Test
    void lotto_ticket_count() {
        Money money = Money.of(14000);

        assertThat(money.lottoTicketCount()).isEqualTo(14);
    }
}