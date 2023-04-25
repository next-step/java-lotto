package lotto;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {
    @DisplayName("로또 티켓은 6개의 로또번호로 구성된다")
    @Test
    void lottoTicketCount() {
        LottoTicket lottoTicket = LottoTicket.of(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호가 6개가 아닌 경우 예외 발생")
    @Test
    void checkSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessageMatching("로또 티켓은 6개의 로또 번호로만 구성됩니다.");
    }

    @DisplayName("중복된 로또 번호인 경우 예외 발생")
    @Test
    void checkDuplicate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoTicket.of(List.of(1, 1, 2, 3, 4, 5)))
                .withMessageMatching("로또 번호는 중복이 허용되지 않습니다.");
    }
}
