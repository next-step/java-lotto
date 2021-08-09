package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        Lotto firstWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto thirdWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto fourthWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        Lotto fifthWinningNumbers = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        LottoNumber matchedBonusNumber = LottoNumber.valueOf(6);
        LottoNumber notMatchedBonusNumber = LottoNumber.valueOf(10);

        // when, then
        assertSame(WinningRank.findWinningRank(lotto, new DrawNumbers(firstWinningNumbers, notMatchedBonusNumber)),
                WinningRank.FIRST_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new DrawNumbers(thirdWinningNumbers, matchedBonusNumber)),
                WinningRank.SECOND_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new DrawNumbers(thirdWinningNumbers, notMatchedBonusNumber)),
                WinningRank.THIRD_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new DrawNumbers(fourthWinningNumbers, notMatchedBonusNumber)),
                WinningRank.FOURTH_PLACE);

        assertSame(WinningRank.findWinningRank(lotto, new DrawNumbers(fifthWinningNumbers, notMatchedBonusNumber)),
                WinningRank.FIFTH_PLACE);
    }

    @DisplayName("일치하는 당첨 번호가 3개 미만이면 MISS다.")
    @ParameterizedTest
    @CsvSource(value = {"5,6,7,8,9,10", "6,7,8,9,10,11", "7,8,9,10,11,12"}, delimiter = ',')
    public void winningRankMissTest(int first, int second, int third, int fourth, int fifth, int sixth) {
        // given
        Lotto lotto = new Lotto(() -> LottoNumber.getAllLottoNumbers()
                .subList(0, 6));

        Lotto winningNumbers = new Lotto(Arrays.asList(first, second, third, fourth, fifth, sixth));
        LottoNumber bonusBall = LottoNumber.valueOf(45);

        // when, then
        assertSame(WinningRank.findWinningRank(lotto, new DrawNumbers(winningNumbers, bonusBall)),
                WinningRank.MISS);
    }
}
