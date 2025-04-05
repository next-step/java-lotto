package com.nextstep.camp.lotto.domain.vo;

import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.exception.LottoAmountCannotBeZeroOrNegativeException;
import com.nextstep.camp.lotto.domain.exception.LottoAmountNotDivisibleByLottoPriceException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoAmountTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> validAmounts() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(2000, 2),
                Arguments.of(5000, 5),
                Arguments.of(10000, 10),
                Arguments.of(14000, 14)
        );
    }

    @ParameterizedTest(name = "amount={0}, expectedCount={1}")
    @MethodSource("validAmounts")
    void valid_amount_creates_LottoAmount(int input, int expectedCount) {
        LottoAmount amount = LottoAmount.of(input);
        assertEquals(input, amount.getValue());
        assertEquals(expectedCount, amount.lottoCount());
    }

    static Stream<Integer> zeroOrNegativeAmounts() {
        return Stream.of(0, -1, -1000);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("zeroOrNegativeAmounts")
    void zero_or_negative_amount_throws(int input) {
        assertThrows(LottoAmountCannotBeZeroOrNegativeException.class, () -> LottoAmount.of(input));
    }

    static Stream<Integer> notDivisibleBy1000() {
        return Stream.of(999, 1501, 1234, 1999);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("notDivisibleBy1000")
    void not_divisible_by_1000_throws(int input) {
        assertThrows(LottoAmountNotDivisibleByLottoPriceException.class, () -> LottoAmount.of(input));
    }
}
