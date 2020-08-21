package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RankingsTest {
    private Rankings rankings;

    @BeforeEach
    void setUp() {
        rankings = Rankings.of(Arrays.asList(Ranking.values()));
    }

    @DisplayName("랭킹의 카운트 조회 테스트")
    @ParameterizedTest
    @EnumSource(value = Ranking.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "MISS"})
    void rankingCountTest(Ranking ranking) {
        assertThat(rankings.rankingCount(ranking)).isOne();
    }

    @DisplayName("랭킹 당첨금 합계 테스트")
    @Test
    void totalPrizeMoneyTest() {
        int totalPrizeMoney = rankings.getRankings().stream()
                .mapToInt(Ranking::getPrizeMoney)
                .sum();
        assertThat(rankings.totalPrizeMoney()).isEqualTo(totalPrizeMoney);
    }
}