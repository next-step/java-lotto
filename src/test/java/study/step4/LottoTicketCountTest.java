package study.step4;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study.step4.domain.LottoTicketCount;

public class LottoTicketCountTest {

    @Test
    @DisplayName("생성자 테스트")
    public void create() {
        // given
        LottoTicketCount count = new LottoTicketCount(10);
        // when & then
        assertThat(count).isEqualTo(new LottoTicketCount(10));
        assertThat(count).isEqualTo(new LottoTicketCount("10"));
    }

    @Test
    @DisplayName("유효성 테스트")
    public void valid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new LottoTicketCount(-1));
    }
}
