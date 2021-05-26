package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Rank;
import step3.domain.Ranks;

import static org.assertj.core.api.Assertions.assertThat;

class RanksTest {

    @Test
    @DisplayName("일반적인 랭크 카운트를 성공적으로 수행하는 테스트")
    void ranksCountTest() {
        Ranks ranks = new Ranks();
        ranks.addRank(Rank.valueOf(3,false));
        ranks.addRank(Rank.valueOf(4,false));
        ranks.addRank(Rank.valueOf(3,false));

        assertThat(ranks.findCountWithAmount(Rank.FIFTH.getWinningMoney())).isEqualTo(2);
        assertThat(ranks.findCountWithAmount(Rank.FOURTH.getWinningMoney())).isEqualTo(1);
    }

}