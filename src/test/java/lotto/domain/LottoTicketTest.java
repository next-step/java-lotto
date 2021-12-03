package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoTicketTest {

    @Test
    @DisplayName("로또 자동 번호 발급 기능")
    void randomLottoNumbers() {
        assertThatCode(LottoTicket::randomLottoTicket)
                .doesNotThrowAnyException();
    }

    @Test
    void customLottoNumbers() {
        assertThatCode(() -> LottoTicket.customLottoTicket(1, 2, 3, 4, 5, 6))
                .doesNotThrowAnyException();
    }
}
