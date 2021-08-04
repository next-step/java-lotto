package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("당첨 순위 테스트")
public class WinningRankTest {

    @DisplayName("로또 번호 6개, 5개, 4개, 3개가 일치하면 각각 1등, 2등, 3등, 4등이다.")
    @Test
    public void winningRankResultTest() {
        // given
        List<LottoNumber> lottoNumbers = LottoNumber.getAllLottoNumbers()
                .subList(0, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        WinningNumbers firstWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumbers secondWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        WinningNumbers ThirdWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 7, 8));
        WinningNumbers FourthWinningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));

        // then
        assertSame(WinningRank.getWinningRankOf(lotto, firstWinningNumbers), WinningRank.FIRST_PLACE);
        assertSame(WinningRank.getWinningRankOf(lotto, secondWinningNumbers), WinningRank.SECOND_PLACE);
        assertSame(WinningRank.getWinningRankOf(lotto, ThirdWinningNumbers), WinningRank.THIRD_PLACE);
        assertSame(WinningRank.getWinningRankOf(lotto, FourthWinningNumbers), WinningRank.FOURTH_PLACE);
    }
}
