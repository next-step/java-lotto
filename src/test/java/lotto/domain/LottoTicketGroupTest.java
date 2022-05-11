package lotto.domain;

import lotto.exceptions.PurchaseLottoTicketException;
import lotto.pattern.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketGroupTest {

    @Test
    @DisplayName("지출한 돈이 1000원 단위가 아니면 구매할 수 없다.")
    void validate() {
        assertThatThrownBy(() -> new LottoTicketGroup(1001, new TestNumberGenerator()))
                .isInstanceOf(PurchaseLottoTicketException.class);
    }

    @Test
    @DisplayName("1000원 미만을 입력받으면 로또를 구매할 수 없다.")
    void validatePurchaseLotto() {
        assertThatThrownBy(() -> new LottoTicketGroup(999, new TestNumberGenerator()))
                .isInstanceOf(PurchaseLottoTicketException.class);
    }
}