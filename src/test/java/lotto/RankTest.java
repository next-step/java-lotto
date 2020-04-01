package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    @DisplayName("일치하는 번호 갯수를 랭킹으로 변경한다")
    public void getRankReturnsRank() {
        Rank rank = Rank.of(6);

        assertThat(rank).isEqualTo(FIRST);

        rank = Rank.of(5);

        assertThat(rank).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("등수에 따라 당첨 금액을 얻을 수 있다")
    public void getMoneyWithRankReturnsWinningMoney() {
        int money = FIRST.getWinningMoney();

        assertThat(money).isEqualTo(2000000000);
    }
}
