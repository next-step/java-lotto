package com.nextstep.lotto.lottoGame.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    void matchCount() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers.getMatchCount(Set.of(1, 2, 3, 4, 5, 7))).isEqualTo(5);
    }

    @Test
    void matchBonus() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers.isMatchBonus(Set.of(1, 2, 3, 4, 5, 7))).isTrue();
        assertThat(winningNumbers.isMatchBonus(Set.of(1, 2, 3, 4, 5, 6))).isFalse();
    }
}
