package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    @Test
    @DisplayName("로또 번호 중복 확인")
    void generateLottoNumbers_duplicate() {
        LottoTicket lottoTicket = LottoTicket.createRandom();
        assertThat(lottoTicket.getLottoNumbers()).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("로또 번호 개수 확인")
    void generateLottoNumbers_size() {
        LottoTicket lottoTicket = LottoTicket.createRandom();
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호 범위 확인")
    void generateLottoNumbers_range() {
        LottoTicket lottoTicket = LottoTicket.createRandom();
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            assertThat(lottoNumber.getNumber()).isBetween(1, 45);
        }
    }

    @Test
    @DisplayName("로또 번호 생성 확인")
    void generateLottoNumbers() {
        LottoTicket lottoTicket = new LottoTicket(List.of(
            new LottoNumber(11), new LottoNumber(27), new LottoNumber(43),
            new LottoNumber(34), new LottoNumber(25), new LottoNumber(6)
        ));
        assertThat(lottoTicket.getLottoNumbers()).containsExactly(
            new LottoNumber(6), new LottoNumber(11), new LottoNumber(25),
            new LottoNumber(27), new LottoNumber(34), new LottoNumber(43)
        );
    }

    @Test
    @DisplayName("로또 번호 일치 확인")
    void matchCount() {
        LottoTicket lottoTicket = new LottoTicket(List.of(
            new LottoNumber(6), new LottoNumber(11), new LottoNumber(25),
            new LottoNumber(27), new LottoNumber(34), new LottoNumber(43)
        ));
        LottoTicket winningNumbers = new LottoTicket(List.of(
            new LottoNumber(11), new LottoNumber(12), new LottoNumber(25),
            new LottoNumber(27), new LottoNumber(44), new LottoNumber(45)
        ));
        assertThat(lottoTicket.matchCount(winningNumbers)).isEqualTo(3);
    }
}
