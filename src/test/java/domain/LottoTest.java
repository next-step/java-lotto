package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() {
        // 1,2,3,4,5,6 setting
        List<Integer> nums = new ArrayList<>();
        for (int i=1 ; i<=6; i++) {
            nums.add(i);
        }
        lotto = Lotto.generateLotto(nums);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_당첨X() {
        String winningNums = "1,2,7,8,9,10";
        int bonusNum = 45;

        assertThat(lotto.getLottoResultStatus(new WinningLotto(winningNums, bonusNum))).isEqualTo(LottoResultStatus.NONE);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_3개_일치() {
        String winningNums = "1,2,3,8,9,10";
        int bonusNum = 45;
        assertThat(lotto.getLottoResultStatus(new WinningLotto(winningNums, bonusNum))).isEqualTo(LottoResultStatus.WINNING_NUM_3);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_4개_일치() {
        String winningNums = "1,2,3,4,9,10";
        int bonusNum = 45;
        assertThat(lotto.getLottoResultStatus(new WinningLotto(winningNums, bonusNum))).isEqualTo(LottoResultStatus.WINNING_NUM_4);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_5개_일치() {
        String winningNums = "1,2,3,4,5,10";
        int bonusNum = 11;
        assertThat(lotto.getLottoResultStatus(new WinningLotto(winningNums, bonusNum))).isEqualTo(LottoResultStatus.WINNING_NUM_5);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_5개_일치_보너스번호_일치() {
        String winningNums = "1,2,3,4,5,10";
        int bonusNum = 6;
        assertThat(lotto.getLottoResultStatus(new WinningLotto(winningNums, bonusNum))).isEqualTo(LottoResultStatus.WINNING_NUM_5_BONUS);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_6개_일치() {
        String winningNums = "1,2,3,4,5,6";
        int bonusNum = 45;
        assertThat(lotto.getLottoResultStatus(new WinningLotto(winningNums, bonusNum))).isEqualTo(LottoResultStatus.WINNING_NUM_6);
    }
}
