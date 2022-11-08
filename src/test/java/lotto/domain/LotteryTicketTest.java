package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LotteryTicketTest {
    @Test
    void has_not_6_number() {
        assertThatThrownBy(() -> LotteryTicket.of(1))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.INCORRECT_NUMBER_COUNT.getMessage());
    }

    @Test
    void has_6_number() {
        assertThatNoException().isThrownBy(() -> LotteryTicket.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void distinct_count() {
        assertThatThrownBy(() -> LotteryTicket.of(1, 2, 3, 4, 5, 5))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.HAS_SAME_NUMBER.getMessage());
    }

    @Test
    void parse_winning_numbers() {
        assertThat(LotteryTicket.of("1, 2, 3, 4, 5, 6").getLotteryNumbers()).contains(
                LotteryNumber.valueOf(1),
                LotteryNumber.valueOf(2),
                LotteryNumber.valueOf(3),
                LotteryNumber.valueOf(4),
                LotteryNumber.valueOf(5),
                LotteryNumber.valueOf(6)
        );
    }

    @Test
    void find_same_number_count() {
        assertThat(LotteryTicket.of(1, 2, 3, 4, 5, 6).countSameNumbers(LotteryTicket.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,true", "5,true", "6,true", "7,false"})
    void check_contain_number(int number, boolean result) {
        assertThat(LotteryTicket.of(1, 2, 3, 4, 5, 6).contain(LotteryNumber.valueOf(number))).isEqualTo(result);
    }
}
