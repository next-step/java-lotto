package lotto;

import lotto.model.WinningPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.utils.TestUtils.testLottoNumbers;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("getWinningCount 메소드는 당첨된 로또 개수를 반환한다")
    void 테스트_getWinningCount_당첨된_로또_개수_반환한다() {
        // given

        // when
        LottoResult result = getTestLottoResult();

        // then
        assertThat(result.getWinningCount(WinningPrice.FIRST)).isEqualTo(1);
        assertThat(result.getWinningCount(WinningPrice.SECOND)).isEqualTo(1);
        assertThat(result.getWinningCount(WinningPrice.THIRD)).isEqualTo(1);
        assertThat(result.getWinningCount(WinningPrice.FORTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("getYield 메소드는 수익률을 반환한다")
    void 테스트_getYield_수익률_반환() {
        // given

        // when
        LottoResult result = getTestLottoResult();

        // then
        assertThat(result.getYield()).isEqualTo(2001555);
    }

    private LottoResult getTestLottoResult() {
        LottoNumbers winningNumbers = testLottoNumbers();
        LottoPaper firstPaper = new LottoPaper(testLottoNumbers(1,2,3,4,5,6));
        LottoPaper secondPaper = new LottoPaper(testLottoNumbers(1,2,3,4,5,7));
        LottoPaper thirdPaper = new LottoPaper(testLottoNumbers(1,2,3,4,7,8));
        LottoPaper forthPaper = new LottoPaper(testLottoNumbers(1,2,3,7,8,9));
        LottoPaper notwinPaper = new LottoPaper(testLottoNumbers(1,2,7,8,9,10));

        return new LottoResult(Arrays.asList(firstPaper, secondPaper, thirdPaper,
                forthPaper, notwinPaper),
                winningNumbers);
    }
}