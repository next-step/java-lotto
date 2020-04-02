package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.Rank.*;
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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("3개 미만으로 번호가 일치하면 당첨 실패로 처리한다")
    public void loseWhenMatchCountLessThanThree(int matchCount) {
        Rank rank = Rank.of(matchCount);

        assertThat(rank).isEqualTo(LOSER);
    }
}
