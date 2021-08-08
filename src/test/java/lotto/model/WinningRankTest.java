package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("당첨 순위 테스트")
public class WinningRankTest {

    @DisplayName("당첨 번호 6개, 5개(그리고 보너스 번호 1개), 5개, 4개, 3개가 일치하면 각각 1등, 2등, 3등, 4등, 5등이다.")
    @Test
    public void winningRankResultTest() {
        // given
        Lotto lotto = new Lotto(() -> LottoNumber.getAllLottoNumbers()
                .subList(0, 6));

        WinningNumbers firstWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers thirdWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningNumbers fourthWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 7, 8));
        WinningNumbers fifthWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));

        LottoNumber matchedBonusNumber = LottoNumber.valueOf(6);
        LottoNumber notMatchedBonusNumber = LottoNumber.valueOf(10);

        // when, then
        assertSame(WinningRank.findWinningRank(lotto, new LotteryNumbers(firstWinningNumbers, notMatchedBonusNumber)),
                WinningRank.FIRST_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new LotteryNumbers(thirdWinningNumbers, matchedBonusNumber)),
                WinningRank.SECOND_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new LotteryNumbers(thirdWinningNumbers, notMatchedBonusNumber)),
                WinningRank.THIRD_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new LotteryNumbers(fourthWinningNumbers, notMatchedBonusNumber)),
                WinningRank.FOURTH_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new LotteryNumbers(fifthWinningNumbers, notMatchedBonusNumber)),
                WinningRank.FIFTH_PLACE);
    }
}
