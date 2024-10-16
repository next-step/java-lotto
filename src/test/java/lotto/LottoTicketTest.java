package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("로또 번호 생성 확인")
    void generateLottoNumbers() {
        LottoTicket lottoTicket = new LottoTicket(List.of(11, 27, 43, 34, 25, 6));
        assertThat(lottoTicket.getLottoNumbers()).containsExactly(6, 11, 25, 27, 34, 43);
    }

    @Test
    @DisplayName("로또 번호 일치 확인")
    void matchCount() {
        LottoTicket lottoTicket = new LottoTicket(List.of(6, 11, 25, 27, 34, 43));
        LottoTicket winningNumbers = new LottoTicket(List.of(11, 12, 25, 27, 44, 45));
        assertThat(lottoTicket.matchCount(winningNumbers)).isEqualTo(3);
    }
}
