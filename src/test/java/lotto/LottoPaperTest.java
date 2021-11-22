package lotto;

import lotto.model.WinningPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.TestUtils.testLottoNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoPaperTest {

    @Test
    @DisplayName("getWinningPrice 메소드는 로또 당첨 금액을 반환한다")
    void 테스트_getWinningPrice_당첨_금액_반환한다() {
        // given
        int count = 6;
        LottoNumbers winningNumbers = testLottoNumbers();

        // when
        LottoPaper firstPaper = new LottoPaper(testLottoNumbers(1,2,3,4,5,6));
        LottoPaper secondPaper = new LottoPaper(testLottoNumbers(1,2,3,4,5,7));
        LottoPaper thirdPaper = new LottoPaper(testLottoNumbers(1,2,3,4,7,8));
        LottoPaper forthPaper = new LottoPaper(testLottoNumbers(1,2,3,7,8,9));
        LottoPaper notwinPaper = new LottoPaper(testLottoNumbers(1,2,7,8,9,10));

        // then
        assertThat(firstPaper.getWinningPrice(winningNumbers)).isEqualTo(WinningPrice.FIRST);
        assertThat(secondPaper.getWinningPrice(winningNumbers)).isEqualTo(WinningPrice.SECOND);
        assertThat(thirdPaper.getWinningPrice(winningNumbers)).isEqualTo(WinningPrice.THIRD);
        assertThat(forthPaper.getWinningPrice(winningNumbers)).isEqualTo(WinningPrice.FORTH);
        assertThat(notwinPaper.getWinningPrice(winningNumbers)).isEqualTo(WinningPrice.NOTWIN);
    }
}