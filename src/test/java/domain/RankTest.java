package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치하는 갯수에 대한 랭킹을 구한다.")
    @Test
    void test01() {
        Rank rank = Rank.of(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("당첨금을 구한다.")
    @Test
    void test02() {
        int result = Rank.FOURTH.prizeMoney(2);
        assertThat(result).isEqualTo(100000);
    }
}
