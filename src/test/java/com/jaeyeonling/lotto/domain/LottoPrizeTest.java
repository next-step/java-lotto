package com.jaeyeonling.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @DisplayName("매칭 갯수에 맞는 상금 응답 확인 ")
    @Test
    void should_return_zero_when_lose() {
        final LottoPrize prize = LottoPrize.valueOf(0);

        final int prizeMoney = prize.getPrizeMoney();

        assertThat(prizeMoney).isEqualTo(0);
    }
}
