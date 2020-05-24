package com.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    @DisplayName("당첨 번호와 로또 번호가 몇 개 일치하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    void getNumberOfMatchingWithWinningNumberTest(
            final Lotto lotto,
            final List<Integer> winningNumbers,
            final Integer expectedCount
    ) {
        Integer result = lotto.getNumberOfMatchingWithWinningNumber(winningNumbers);
        assertTrue(result.equals(expectedCount));
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), 0), Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), 0), Arrays.asList(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), 0), Arrays.asList(7, 8, 9, 10, 11, 12), 0)
        );
    }
}
