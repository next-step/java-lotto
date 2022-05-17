package lotto.domain;

import lotto.exceptions.InvalidManualLottoCountException;
import lotto.exceptions.PurchaseLottoTicketException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PayTest {
    @Test
    @DisplayName("지출한 돈이 1000원 단위가 아니면 구매할 수 없다.")
    void validate() {
        assertThatThrownBy(() -> new Pay(1001))
                .isInstanceOf(PurchaseLottoTicketException.class);
    }

    @Test
    @DisplayName("1000원 미만을 입력받으면 로또를 구매할 수 없다.")
    void validatePurchaseLotto() {
        assertThatThrownBy(() -> new Pay(999))
                .isInstanceOf(PurchaseLottoTicketException.class);
    }

    @Test
    @DisplayName("지불한 금액보다 더 많은 수동으로 로또수를 선택 할 수 없다.")
    void validatePurchaseManualLotto() {
        assertThatThrownBy(() -> new Pay(2000, 3))
                .isInstanceOf(InvalidManualLottoCountException.class);
    }

    @Test
    @DisplayName("10장을 살때 수동으로 N장을 사면 자동으론 10-N장을 구입해야한다.")
    void purchaseAutoAndManualTest() {
        assertThat(new Pay(10000, 3).getAutoTicketCount()).isEqualTo(7);
    }
}
