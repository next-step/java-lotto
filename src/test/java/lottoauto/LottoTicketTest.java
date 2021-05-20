package lottoauto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket();
    }

    @DisplayName("로또티켓 가격 테스트")
    @Test
    void 로또티켓가격() {
        assertThat(lottoTicket.price()).isEqualTo(1000);
    }
}
