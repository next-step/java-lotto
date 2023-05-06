package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static lotto.domain.RewardType.FIVE;
import static lotto.domain.RewardType.FIVE_AND_BONUS;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRewardsTest {

    LottoRewards lottoRewards;

    @BeforeEach
    void setUp() {
        lottoRewards = new LottoRewards();
    }

    @Test
    void 초기_count() {
        assertThat(lottoRewards.get(FIVE).count()).isEqualTo(0);
    }

    @Test
    void count_증가() {
        lottoRewards.increaseCountOf(FIVE);

        assertThat(lottoRewards.get(FIVE).count()).isEqualTo(1);
    }

    @Test
    void 총_수익_계산() {
        lottoRewards.increaseCountOf(FIVE);
        lottoRewards.increaseCountOf(FIVE_AND_BONUS);
        long expectTotalProfit = FIVE.reward() + FIVE_AND_BONUS.reward();

        assertThat(lottoRewards.totalProfit()).isEqualTo(expectTotalProfit);
    }
}
