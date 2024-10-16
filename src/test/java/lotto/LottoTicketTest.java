package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @Test
    @DisplayName("로또 번호 중복 확인")
    void generateLottoNumbers_duplicate() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.getLottoNumbers()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("로또 번호 개수 확인")
    void generateLottoNumbers_size() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호 범위 확인")
    void generateLottoNumbers_range() {
        LottoTicket lottoTicket = new LottoTicket();
        for (int lottoNumber : lottoTicket.getLottoNumbers()) {
            assertThat(lottoNumber).isBetween(1, 45);
        }
    }
}
