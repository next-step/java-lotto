package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryTicketTest {
    @Test
    void has_not_6_number() {
        assertThatThrownBy(() -> new LotteryTicket(List.of(new LotteryNumber(1))))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.INCORRECT_NUMBER_COUNT.getMessage());
    }

    @Test
    void has_6_number() {
        assertThatNoException().isThrownBy(() -> new LotteryTicket(
                List.of(new LotteryNumber(1),
                        new LotteryNumber(2),
                        new LotteryNumber(3),
                        new LotteryNumber(4),
                        new LotteryNumber(5),
                        new LotteryNumber(6)
                )));
    }

    @Test
    void distinct_count() {
        assertThatThrownBy(() -> new LotteryTicket(
                List.of(new LotteryNumber(1),
                        new LotteryNumber(2),
                        new LotteryNumber(3),
                        new LotteryNumber(4),
                        new LotteryNumber(5),
                        new LotteryNumber(5)
                )))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.HAS_SAME_NUMBER.getMessage());
    }
}
