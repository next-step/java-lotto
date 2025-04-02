package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 6개의 숫자로 이루어져 있다.")
    void shouldHaveSixNumbers() {
        LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(6, lottoTicket.getNumbers().size());
    }

    @Test
    @DisplayName("로또 티켓은 1부터 45 사이의 숫자로 이루어져 있다.")
    void shouldHaveNumbersBetweenOneAndFortyFive() {
        assertThatThrownBy(() -> new LottoTicket(List.of(0, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 티켓은 1부터 45 사이의 숫자로 이루어져 있어야 합니다.");

        assertThatThrownBy(() -> new LottoTicket(List.of(46, 2, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 티켓은 1부터 45 사이의 숫자로 이루어져 있어야 합니다.");
    }

    @Test
    @DisplayName("로또 티켓은 중복된 숫자를 포함할 수 없다.")
    void shouldNotHaveDuplicateNumbers() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 1, 3, 4, 5, 6)))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 티켓은 중복된 숫자를 포함할 수 없습니다.");
    }

}