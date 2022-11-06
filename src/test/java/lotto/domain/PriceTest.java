package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {
    @Test
    void under_lottery_ticket_price() {
        assertThatThrownBy(() -> new Price(999))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.OUT_OF_RANGE_PRICE.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void null_or_empty(String price) {
        assertThatThrownBy(() -> new Price(price))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY.getMessage());
    }

    @Test
    void calculate_amount() {
        assertThat(new Price(10000).calculateAmount()).isEqualTo(new Amount(10));
    }

    @Test
    void cannot_divide_by_ticket_price() {
        assertThatThrownBy(() -> new Price(1500))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.CANNOT_DIVIDE_BY_TICKET_PRICE.getMessage());
    }
}
