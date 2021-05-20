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

    @DisplayName("로또번호발생(1~45 중복되지않은 6개의 숫자) 테스트")
    @Test
    void 로또번호발생() {
        List<Integer> lottoNumbers = lottoTicket.generateLottoNumbers();
        assertThat(new HashSet<>(lottoNumbers).size()).isEqualTo(6);
        assertThat(lottoNumbers).allMatch(integer -> integer >= 1 && integer <= 45);
    }
}
