package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("입력으로 들어온 갯수를 기반으로 당첨금을 구한다.")
    @Test
    void test01() {
        int result = Rank.FOURTH.prizeMoney(2);
        assertThat(result).isEqualTo(100000);
    }

    @DisplayName("일치하는 번호의 갯수를 기반으로 랭킹을 구한다.")
    @Test
    void test02() {
        Rank rank = Rank.of(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
}
