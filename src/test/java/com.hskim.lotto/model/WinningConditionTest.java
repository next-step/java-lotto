package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningConditionTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        WinningCondition winningCondition = new WinningCondition(5);

        // when & then
        assertThat(winningCondition).isEqualTo(new WinningCondition(5));
    }
}
