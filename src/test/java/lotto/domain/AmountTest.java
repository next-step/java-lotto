package lotto.domain;

import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AmountTest {

    @Test
    @DisplayName("로또 수동, 자동 수량")
    void getAmount() {
        // given / when
        Amount amount = new Amount(10, 5);

        // then
        assertThat(amount.getAutoAmount()).isEqualTo(5);
        assertThat(amount.getManualAmount()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 수량 벨리데이션 확인")
    void getAmount_fail() {
        // expected
        assertThatThrownBy(() -> new Amount(10, 11))
                .isInstanceOf(InvalidInputException.class);
    }

}
