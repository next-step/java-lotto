package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchLottoTest {

    //match의 기능
    //count list
    //bonus count

    @Test
    public void 보너스_당첨_횟수확인() {
        int[] matchCount = {0, 1, 2, 3, 4, 5, 6};
        int bonusCount = 3;

        MatchLotto matchLotto = new MatchLotto(matchCount, bonusCount);
        assertThat(matchLotto.getBonusCount()).isEqualTo(3);

        for (int i : matchCount) {
            assertThat(matchLotto.checkMatchCount(i)).isEqualTo(i);
        }
    }

    @Test
    public void 당첨금_계산하기() {
        int[] matchCount = {0, 0, 0, 1, 0, 2, 0};
        int bonusCount = 1;

        MatchLotto matchLotto = new MatchLotto(matchCount, bonusCount);
        long prizeMoney = matchLotto.sumPrizeMoney();
        assertThat(prizeMoney).isEqualTo(33_005_000);
    }

    @Test
    public void 보너스_3등_당첨금_계산하기() {
        int[] matchCount = {0, 0, 0, 0, 0, 1, 0};
        int bonusCount = 1;

        MatchLotto matchLotto = new MatchLotto(matchCount, bonusCount);
        long prizeMoney = matchLotto.sumPrizeMoney();
        assertThat(prizeMoney).isEqualTo(31_500_000);
    }
}
