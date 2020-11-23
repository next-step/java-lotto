package step04.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step04.Rank;

import static org.assertj.core.api.Assertions.assertThat;

public class RankCounterTest {
    RankCounter rankCounter;
    Rank rank;

    @BeforeEach
    void setup() {
        rankCounter = RankCounter.of();
        rank = Rank.valueOf(3, false);
    }

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(rankCounter).isEqualTo(RankCounter.of());
    }

    @Test
    void test_getCount_put() {
        Rank rank = Rank.valueOf(3, false);
        rankCounter.put(rank, 1);
        assertThat(rankCounter.getCount(rank)).isEqualTo(1);
    }

    @Test
    void test_increase() {
        Rank rank = Rank.valueOf(3, false);
        rankCounter.increase(rank);
        assertThat(rankCounter.getCount(rank)).isEqualTo(1);
    }

    @Test
    void test_calculateRewardAll() {
        rankCounter.put(Rank.valueOf(3, false), 1);
        rankCounter.put(Rank.valueOf(0, false), 13);

        assertThat(rankCounter.calculateRewardAll()).isEqualTo(5000);
    }

    @Test
    void test_getTotalCount() {
        rankCounter.put(Rank.valueOf(3, false), 1);
        rankCounter.put(Rank.valueOf(0, false), 13);

        assertThat(rankCounter.getTotalCount()).isEqualTo(14);
    }

    @Test
    public void test_calculateGainRate() {
        rankCounter.put(Rank.valueOf(3, false), 1);
        rankCounter.put(Rank.valueOf(0, false), 13);

        assertThat(rankCounter.calculateGainRate()).isEqualTo(0.35714285714285715);
    }
}
