package lotto.domain;

import lotto.pattern.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketGroupTest {

    @Test
    @DisplayName("지출한 돈이 1000원 단위가 아니면 구매할 수 없다.")
    void validate() {
        int money = 1001;
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicketGroup(money, new LottoNumberGenerator()));
    }

    @Test
    @DisplayName("1000원 미만을 입력받으면 로또를 구매할 수 없다.")
    void validatePurchaseLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicketGroup(999, new LottoNumberGenerator()));
    }
}