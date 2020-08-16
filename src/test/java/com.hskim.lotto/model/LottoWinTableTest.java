package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTableTest {

    @DisplayName("find() 테스트")
    @ParameterizedTest
    @MethodSource("provideWinTableAndCondition")
    void find(WinningCondition winningCondition, Optional<LottoWinTable> expected) {
        // when & then
        assertThat(LottoWinTable.find(winningCondition)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWinTableAndCondition() {
        return Stream.of(
                Arguments.of(new WinningCondition(6), Optional.of(LottoWinTable.FIRST_PLACE)),
                Arguments.of(new WinningCondition(5), Optional.of(LottoWinTable.SECOND_PLACE)),
                Arguments.of(new WinningCondition(4), Optional.of(LottoWinTable.THIRD_PLACE)),
                Arguments.of(new WinningCondition(3), Optional.of(LottoWinTable.FOURTH_PLACE)),
                Arguments.of(new WinningCondition(2), Optional.empty())
        );
    }
}
