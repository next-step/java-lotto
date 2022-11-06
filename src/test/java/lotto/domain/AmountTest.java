package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import lotto.strategy.AutoGenerateStrategy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;

public class AmountTest {
    @Test
    void amount_under_zero() {
        assertThatThrownBy(() -> new Amount(-1))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.AMOUNT_UNDER_ZERO.getMessage());
    }

    @Test
    void amount_over_zero() {
        assertThatNoException().isThrownBy(() -> new Amount(0));
    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    void null_or_empty(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY.getMessage());
    }

    @Test
    void create_lottery_ticket_with_amount() {
        LotteryTickets lotteryTickets = new Amount(2).createTickets(new AutoGenerateStrategy());
        assertThat(lotteryTickets).isInstanceOf(LotteryTickets.class);
        assertThat(lotteryTickets.getLotteryTickets()).hasSize(2);
    }

    @Test
    void minus_amount() {
        assertThat(new Amount(10).minus(new Amount(2))).isEqualTo(new Amount(8));
    }
}
