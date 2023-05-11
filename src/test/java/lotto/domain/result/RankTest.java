package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName(value = "당첨 로또 번호가 3개 이상일 경우 검사")
    void test1() {
        Rank rank = Rank.valueOf(3);
        assertThat(rank.getHit()).isEqualTo(3);
        assertThat(rank.getReward()).isEqualTo(5_000);
    }

    @Test
    @DisplayName(value = "당첨 로또 번호가 2개 이하일 경우 검사")
    void test2() {
        Rank rank = Rank.valueOf(2);
        assertThat(rank.getHit()).isEqualTo(0);
        assertThat(rank.getReward()).isEqualTo(0);
    }
}

