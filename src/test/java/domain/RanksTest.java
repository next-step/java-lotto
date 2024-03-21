package domain;

import java.util.List;

import domain.Rank;
import domain.Ranks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @DisplayName("랭킹별 갯수를 구한다.")
    @Test
    void test01() {
        // given
        Ranks ranks = new Ranks(List.of(Rank.FIRST, Rank.FOURTH));

        // when
        int result = ranks.count(Rank.FIRST);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("전체 당첨금을 구한다.")
    @Test
    void test() {
        // given
        Ranks ranks = new Ranks(List.of(Rank.THIRD, Rank.FOURTH));

        // when
        int result = ranks.totalPrizeMoney();

        // then
        assertThat(result).isEqualTo(55000);
    }
}
