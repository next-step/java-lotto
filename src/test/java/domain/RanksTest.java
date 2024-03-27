package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RanksTest {

    @DisplayName("특정 랭킹의 갯수를 구한다.")
    @Test
    void test01() {
        Ranks ranks = new Ranks(List.of(Rank.FIRST, Rank.FIFTH));

        int result = ranks.count(Rank.FIRST);

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("전체 당첨금을 구한다.")
    @Test
    void test02() {
        Ranks ranks = new Ranks(List.of(Rank.FOURTH, Rank.FIFTH));

        int result = ranks.totalPrizeMoney();

        assertThat(result).isEqualTo(55000);
    }

    @DisplayName("전체 랭킹 갯수를 구한다.")
    @Test
    void test03() {
        Ranks ranks = new Ranks(List.of(Rank.FIRST, Rank.SECOND, Rank.THIRD));
        assertThat(ranks.totalCount()).isEqualTo(3);
    }

    @DisplayName("수익률을 구한다.")
    @Test
    void test04() {
        Ranks ranks = new Ranks(List.of(Rank.FOURTH, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE));
        double rateOfReturn = ranks.rateOfReturn();
        assertThat(rateOfReturn).isEqualTo(10.0);
    }
}
