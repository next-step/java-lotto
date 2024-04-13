package lottopackage;

import lottopackage.domain.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PrizeTest {

    @Test
    @DisplayName("isPrize() - 당첨 등수 확인")
    public void isPrize() {
        // given
        WinningNumberAndBonusBall winningNumberAndBonusBall = new WinningNumberAndBonusBall(new LottoBalls(1, 2, 3, 4, 5, 6), new LottoBall(45));
        Prize[] prize = Prize.values();

        // when
        LottoBalls winningNumber1st = new Lotto(1, 2, 3, 4, 5, 6).getLotto();
        LottoBalls winningNumber2nd = new Lotto(1, 2, 3, 4, 5, 45).getLotto();
        LottoBalls winningNumber3rd = new Lotto(1, 2, 3, 4, 5, 7).getLotto();
        LottoBalls winningNumber4th = new Lotto(1, 2, 3, 4, 7, 8).getLotto();
        LottoBalls winningNumber5th = new Lotto(1, 2, 3, 7, 8, 9).getLotto();
        LottoBalls noWinningNumber = new Lotto(11, 12, 13, 14, 15, 16).getLotto();
        List<LottoBalls> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber2nd, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber));

        // then
        for (int i = 0; i < prize.length; i++) {
            LottoBalls lottoBalls = lottoGroup.get(i);
            Assertions.assertThat(Prize.checkPrize(lottoBalls, winningNumberAndBonusBall)).isEqualTo(prize[i]);
        }
    }
}
