package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void out_of_range(int number) {
        assertThatThrownBy(() -> LotteryNumber.number(number))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void null_or_empty(String number) {
        assertThatThrownBy(() -> LotteryNumber.number(number))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.NULL_OR_EMPTY.getMessage());
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 45})
    void create_lottery_number(int number) {
        assertThatNoException().isThrownBy(() -> LotteryNumber.number(number));
    }
}
