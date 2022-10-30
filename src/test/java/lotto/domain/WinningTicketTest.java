package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningTicketTest {
    @Test
    void create() {
        assertThatNoException().isThrownBy(() -> new WinningTicket(
                LotteryTicket.of(1, 2, 3, 4, 5, 6), new LotteryNumber(7)
        ));
    }

    @Test
    void duplicate_winning_number_and_bonus_boll() {
        assertThatThrownBy(() -> new WinningTicket(
                LotteryTicket.of(1, 2, 3, 4, 5, 6), new LotteryNumber(6))
        ).isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.HAS_SAME_NUMBER.getMessage());
    }
}
