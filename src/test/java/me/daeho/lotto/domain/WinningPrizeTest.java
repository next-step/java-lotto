package me.daeho.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningPrizeTest {
    WinningPrize winningPrize;

    @BeforeEach
    public void setup() {
        winningPrize = WinningPrize.create();
    }

    @Test
    public void setting() {
        winningPrize.setting(1, 5000)
                .setting(2, 3000);

        assertThat(winningPrize.size()).isEqualTo(2);
    }

    @Test
    public void prize() {
        winningPrize.setting(1, 5000)
                .setting(2, 3000);

        assertThat(winningPrize.prize(1)).isEqualTo(5000);
        assertThat(winningPrize.prize(2)).isEqualTo(3000);
    }
}