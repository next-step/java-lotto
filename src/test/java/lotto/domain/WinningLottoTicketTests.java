package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTicketTests {

    @DisplayName("정상정인 input(, 정상적으로) 생성 테스트")
    @Test
    void validInputCreateTest() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1, 2, 3, 4, 5, 6");

        assertThat(winningLottoTicket).isEqualTo(WinningLottoTicket.of("1, 2, 3, 4, 5, 6"));
    }

    @DisplayName(", 띄어쓰기 멋대로 했을 때 생성 테스트")
    @Test
    void spaceInputCreateTest() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1,2 ,  3, 4, 5,6");

        assertThat(winningLottoTicket).isEqualTo(WinningLottoTicket.of("1,2 ,  3, 4, 5,6"));
    }

    @DisplayName("contains 테스트")
    @Test
    void containsTest() {
        WinningLottoTicket winningLottoTicket = WinningLottoTicket.of("1,2 ,  3, 4, 5,6");

        assertThat(winningLottoTicket.contains(LottoNumber.of(6))).isEqualTo(true);
    }
}
