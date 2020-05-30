package com.lotto.domain;

import com.lotto.domain.LottoBonusBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusBallTest {

    @DisplayName("Bonus Ball 이 맞는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningNumbers")
    void getNumberOfMatchingWithBonusNumber(final List<Integer> winningNumbers, final Integer bonusBallNumber, final Integer expected) {

        LottoBonusBall lottoBonusBall = new LottoBonusBall(bonusBallNumber);
        Integer result = lottoBonusBall.getNumberOfMatchingWithBonusNumber(winningNumbers);

        assertEquals(result, expected);
    }

    private static Stream<Arguments> provideWinningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 2, 1),
                Arguments.of(Arrays.asList(2, 3, 4, 5, 6, 8), 11, 0)
        );
    }
}
