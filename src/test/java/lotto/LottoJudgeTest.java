package lotto;

import lotto.common.type.WinnerRank;
import lotto.service.*;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoJudgeTest {

    @Test
    @DisplayName("로또 번호와 당첨 번호가 주어졌을 때 WinnerCount 반환 확인 ")
    void testIfGetValidWinnerCount(){
        Lotto lotto1 = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(Arrays.asList(11,2,3,4,5,6));
        Lotto lotto3 = new Lotto(Arrays.asList(11,22,3,4,5,6));
        Lotto lotto4 = new Lotto(Arrays.asList(11,22,33,4,5,6));
        Lottos lottos = new Lottos(Arrays.asList(lotto1, lotto2, lotto3, lotto4));
        Lotto winningLottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));

        LottoJudge lottoJudge = new LottoJudge();
        RewardCalculator result = lottoJudge.judge(lottos, winningLottoNumbers, "7");

        RewardCalculator expected = new RewardCalculator();
        expected.plusCount(WinnerRank.FIRST);
        expected.plusCount(WinnerRank.THIRD);
        expected.plusCount(WinnerRank.FORTH);
        expected.plusCount(WinnerRank.FIFTH);
        assertThat(result).isEqualTo(expected);
    }
}
