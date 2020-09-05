package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("일치하는 숫자 개수 확인")
    void drawing() {
        LottoNumbers winningNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);

        assertThat(new LottoTicket(LottoNumbers.of(7, 8, 9, 10, 11, 12)).drawing(winningNumbers)).isEqualTo(0);
        assertThat(new LottoTicket(LottoNumbers.of(1, 8, 9, 10, 11, 12)).drawing(winningNumbers)).isEqualTo(1);
        assertThat(new LottoTicket(LottoNumbers.of(1, 2, 9, 10, 11, 12)).drawing(winningNumbers)).isEqualTo(2);
        assertThat(new LottoTicket(LottoNumbers.of(1, 2, 3, 7, 8, 9)).drawing(winningNumbers)).isEqualTo(3);
        assertThat(new LottoTicket(LottoNumbers.of(1, 2, 3, 4, 8, 9)).drawing(winningNumbers)).isEqualTo(4);
        assertThat(new LottoTicket(LottoNumbers.of(1, 2, 3, 4, 5, 9)).drawing(winningNumbers)).isEqualTo(5);
        assertThat(new LottoTicket(LottoNumbers.of(1, 2, 3, 4, 5, 6)).drawing(winningNumbers)).isEqualTo(6);
    }
}
