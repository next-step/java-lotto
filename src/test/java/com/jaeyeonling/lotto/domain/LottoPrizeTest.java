package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @DisplayName("매칭 갯수에 맞는 상금 응답 확인 ")
    @Test
    void should_return_prizeMoney() {
        assertThat(LottoPrize.valueOf(Env.JACKPOT_COUNT_OF_MATCH).getPrizeMoney()).isEqualTo(Env.JACKPOT_PRIZE_MONEY);
        assertThat(LottoPrize.valueOf(Env.FOURTH_COUNT_OF_MATCH).getPrizeMoney()).isEqualTo(Env.FOURTH_PRIZE_MONEY);
        assertThat(LottoPrize.valueOf(Env.LOSE_COUNT_OF_MATCH).getPrizeMoney()).isEqualTo(Env.LOSE_PRIZE_MONEY);
    }
}
