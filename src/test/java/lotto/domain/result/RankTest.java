package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName(value = "당첨 로또 번호가 3개 이상일 경우 검사")
    void test1() {
        Rank rank = Rank.valueOf(3, false);
        assertThat(rank.getHit()).isEqualTo(3);
        assertThat(rank.getReward()).isEqualTo(5_000);
    }

    @Test
    @DisplayName(value = "당첨 로또 번호가 2개 이하일 경우 검사")
    void test2() {
        Rank rank = Rank.valueOf(2, false);
        assertThat(rank.getHit()).isEqualTo(0);
        assertThat(rank.getReward()).isEqualTo(0);
    }

    @Test
    @DisplayName(value = "당첨 로또 번호가 5개이고 bonus 번호까지 맞을 경우")
    void test3() {
        Rank rank = Rank.valueOf(5, true);
        assertThat(rank.getHit()).isEqualTo(5);
        assertThat(rank.getReward()).isEqualTo(30_000_000);
    }

    @Test
    @DisplayName(value = "당첨 로또 번호가 5개이고 bonus 번호는 안맞았을 경우")
    void test4() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank.getHit()).isEqualTo(5);
        assertThat(rank.getReward()).isEqualTo(1_500_000);
    }
}

