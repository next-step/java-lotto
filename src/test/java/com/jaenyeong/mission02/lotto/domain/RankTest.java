package com.jaenyeong.mission02.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("복권 당첨 등수, 당첨금에 대한 정보를 가지고 있는 Rank Enum 테스트")
class RankTest {

    @Test
    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하는 2등이 당첨된 경우 테스트")
    void secondRankTest() {
        final int countOfMatch = 5;
        final boolean bonusMatch = true;

        final Rank rank = Rank.valueOf(bonusMatch, countOfMatch);

        assertEquals(rank, Rank.SECOND);
    }

    @Test
    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하지 않는 3등이 당첨된 경우 테스트")
    void thirdRankTest() {
        final int countOfMatch = 5;
        final boolean bonusMatch = false;

        final Rank rank = Rank.valueOf(bonusMatch, countOfMatch);

        assertEquals(rank, Rank.THIRD);
    }
}
