package step3.lotto;

import org.junit.jupiter.api.*;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket();
    }

    @DisplayName("lottoTicket 번호 랜덤 출력 확인")
    @RepeatedTest(100)
    void getLottoNumbers() {
        log.println(lottoTicket.getLottoNumbers());
    }

    @DisplayName("lottoTicket 번호 랜덤으로 6자리 생성 확인")
    @RepeatedTest(100)
    void checkDigits() {
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }
}