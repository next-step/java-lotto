package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoCheckerTest {

    @DisplayName("당첨된 숫자 계수")
    @ParameterizedTest
    @MethodSource
    void checkHitCount(List<Integer> collectNumbers, int expected) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int count = LottoChecker.checkHitCount(winningNumbers, collectNumbers);
        assertThat(count).isEqualTo(expected);
    }

    private static Stream<Arguments> checkHitCount() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 6),
                Arguments.of(Arrays.asList(11,2,3,4,5,6), 5),
                Arguments.of(Arrays.asList(11,12,3,4,5,6), 4),
                Arguments.of(Arrays.asList(11,12,13,4,5,6), 3),
                Arguments.of(Arrays.asList(11,12,13,14,5,6), 2),
                Arguments.of(Arrays.asList(11,12,13,14,15,6), 1),
                Arguments.of(Arrays.asList(11,12,13,14,15,16), 0)
        );
    }
}
