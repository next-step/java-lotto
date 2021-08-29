package lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {
    @DisplayName("로또 티켓 리스트는 n장의 로또 티켓으로 초기화 된다. ")
    @Test
    void createLottoTickets() {
        int[][] numbers = {{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 7}, {1, 2, 3, 4, 8, 7}};
        assertThat(new LottoTickets(numbers).value().size()).isEqualTo(3);
    }
}
