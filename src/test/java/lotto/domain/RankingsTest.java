package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.Arrays;
import java.util.Collections;

import static lotto.domain.LottoStore.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class RankingsTest {
    private Rankings rankings;

    @DisplayName("랭킹의 카운트 조회 테스트")
    @ParameterizedTest
    @EnumSource(value = Ranking.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH", "MISS"})
    void rankingCountTest(Ranking ranking) {
        rankings = Rankings.of(Arrays.asList(Ranking.values()));
        assertThat(rankings.rankingCount(ranking)).isOne();
    }

    @DisplayName("랭킹 당첨금 합계 테스트")
    @Test
    void totalPrizeMoneyTest() {
        rankings = Rankings.of(Arrays.asList(Ranking.values()));
        assertThat(rankings.totalPrizeMoney()).isEqualTo(rankings.getRankings().stream()
                .mapToInt(Ranking::getPrizeMoney)
                .sum());
    }

    @DisplayName("총 수익률 구하는 테스트")
    @Test
    void findProfitRateTest() {
        rankings = Rankings.of(Collections.singletonList(Ranking.FIFTH));
        assertThat(rankings.findProfitRate())
                .isEqualTo((double) Ranking.FIFTH.getPrizeMoney() / LOTTO_PRICE);
    }
}