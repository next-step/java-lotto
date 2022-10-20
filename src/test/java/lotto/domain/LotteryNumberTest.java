package lotto.domain;

import lotto.exception.ErrorCode;
import lotto.exception.LotteryGameException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void out_of_range(int number) {
        assertThatThrownBy(() -> new LotteryNumber(number))
                .isInstanceOf(LotteryGameException.class)
                .hasMessage(ErrorCode.OUT_OF_RANGE_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 45})
    void create_lottery_number(int number) {
        assertThatNoException().isThrownBy(() -> new LotteryNumber(number));
    }
}
