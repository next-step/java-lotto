package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinTableTest {

    @DisplayName("find() 테스트 - 우승 조건 (WinningCondition)에 맞는 등수를 찾느 로직 검증")
    @ParameterizedTest
    @MethodSource("provideWinTableAndCondition")
    void find(WinningCondition winningCondition, Optional<LottoWinTable> expected) {
        // when & then
        assertThat(LottoWinTable.find(winningCondition)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWinTableAndCondition() {
        return Stream.of(
                Arguments.of(new WinningCondition(6, false), Optional.of(LottoWinTable.FIRST_PLACE)),
                Arguments.of(new WinningCondition(5, true), Optional.of(LottoWinTable.SECOND_PLACE)),
                Arguments.of(new WinningCondition(5, false), Optional.of(LottoWinTable.THIRD_PLACE)),
                Arguments.of(new WinningCondition(4, false), Optional.of(LottoWinTable.FOURTH_PLACE)),
                Arguments.of(new WinningCondition(3, false), Optional.of(LottoWinTable.FIFTH_PLACE)),
                Arguments.of(new WinningCondition(2, false), Optional.empty())
        );
    }
}
