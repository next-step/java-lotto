package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 일급 컬랜셕 생성 테스트(수동)")
    void createTest() {
        LottoTicket lottoTicket = new LottoTicket(3);

        assertThat(lottoTicket.getLotto().size()).isEqualTo(3);
    }
}
