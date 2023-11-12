package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankLottoTest {

    @DisplayName("당첨번호와 일치하는 숫자가 5개인 경우 3등")
    @Test
    void 당첨_1등() {
        // given
        int matchCount = 5;
        boolean bonusCount = false;
        // when
        RankLotto rankLotto = RankLotto.findRank(matchCount, false);
        // then
        assertThat(rankLotto.winningMoney()).isEqualTo(RankLotto.THIRD.winningMoney());
    }

    @DisplayName("당첨번호와 일치하는 숫자가 5개, 보너스1개 일치인 경우 2등")
    @Test
    void 당첨_2등() {
        // given
        int matchCount = 6;
        boolean bonusCount = true;
        // when
        RankLotto rankLotto = RankLotto.findRank(matchCount, true);
        // then
        assertThat(rankLotto.winningMoney()).isEqualTo(RankLotto.SECOND.winningMoney());
    }


    @DisplayName("당첨번호와 일치하는 숫자가 2개인 경우 당첨실패")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void 당첨_없음() {
        // given
        int matchCount = 2;
        // when
        RankLotto rankLotto = RankLotto.findRank(matchCount, false);
        // then
        assertThat(rankLotto.matchCount()).isEqualTo(RankLotto.MISS.matchCount());
        assertThat(rankLotto.winningMoney()).isEqualTo(RankLotto.MISS.winningMoney());
    }
}
