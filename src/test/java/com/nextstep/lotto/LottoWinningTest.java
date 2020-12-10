package com.nextstep.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {

    @DisplayName("맞은 개수에 맞는 등수 나오는지 확인")
    @ParameterizedTest
    @MethodSource
    void winning(List<Integer> collectNumbers, LottoWinning expected) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoWinning winning = LottoWinning.select(winningNumbers, collectNumbers);
        assertThat(winning).isEqualTo(expected);
    }

    private static Stream<Arguments> winning() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), LottoWinning.WIN_1ST),
                Arguments.of(Arrays.asList(11,2,3,4,5,6), LottoWinning.WIN_3RD),
                Arguments.of(Arrays.asList(11,12,3,4,5,6), LottoWinning.WIN_4TH),
                Arguments.of(Arrays.asList(11,12,13,4,5,6), LottoWinning.WIN_5TH),
                Arguments.of(Arrays.asList(11,12,13,14,5,6), LottoWinning.RETIRE),
                Arguments.of(Arrays.asList(11,12,13,14,15,6), LottoWinning.RETIRE),
                Arguments.of(Arrays.asList(11,12,13,14,15,16), LottoWinning.RETIRE)
        );
    }
}
