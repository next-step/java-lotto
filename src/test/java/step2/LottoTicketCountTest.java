package step2;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoTicketCount;

class LottoTicketCountTest {

    @Test
    @DisplayName("구입한 금액 보다 더 큰 수동 로또는 입력이 불가능 합니다.")
    void purchaseLottoTicketCountTest() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoTicketCount(10, 11));
    }

}
