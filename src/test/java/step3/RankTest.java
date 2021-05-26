package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Rank;
import step3.domain.Ranks;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {


    @Test
    @DisplayName("2등으로써 5자리를 맞추고  보너스 숫자를 맞출 경우")
    void correctBonusNumber() {
        Rank rank = Rank.valueOf(Rank.SECOND.getCountOfMatch(), true);

        assertThat(rank.getWinningMoney()).isEqualTo(Rank.SECOND.getWinningMoney());
    }

    @Test
    @DisplayName("3등으로서 5자리를 맞추고 보너스 숫자를 맞추지 못한 경우")
    void inCorrectBonusNumber() {
        Rank rank = Rank.valueOf(Rank.SECOND.getCountOfMatch(), false);

        assertThat(rank.getWinningMoney()).isEqualTo(Rank.THIRD.getWinningMoney());
    }
}