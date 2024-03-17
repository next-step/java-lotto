package lotto.domain;

import lotto.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    @DisplayName("addCorrectLottoCount 호출하면 매개변수에 로또 하나 당 맞춘 개수가 넘어가고 해당하는 변수 가산")
    void addCorrectLottoCount() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.addCorrectLottoCount(2);

        lottoResult.addCorrectLottoCount(3);

        lottoResult.addCorrectLottoCount(4);
        lottoResult.addCorrectLottoCount(4);

        lottoResult.addCorrectLottoCount(5);
        lottoResult.addCorrectLottoCount(5);

        lottoResult.addCorrectLottoCount(6);

    }

    @Test
    @DisplayName("winnings 호출 시 당첨금을 모두 합하여 반환")
    void winnings() {
        LottoResult lottoResult = new LottoResult();
        int countOfThreeCorrect = 1;
        int countOfFourCorrect = 2;
        int countOfFiveCorrect = 3;
        int countOfSixCorrect = 1;

        addResultCount(lottoResult, 3, countOfThreeCorrect);
        addResultCount(lottoResult, 4, countOfFourCorrect);
        addResultCount(lottoResult, 5, countOfFiveCorrect);
        addResultCount(lottoResult, 6, countOfSixCorrect);

        long expectedWinnings = (countOfThreeCorrect * LottoConstants.THREE_NUMBER_CORRECT_WINNINGS)
                + (countOfFourCorrect * LottoConstants.FOUR_NUMBER_CORRECT_WINNINGS)
                + (countOfFiveCorrect * LottoConstants.FIVE_NUMBER_CORRECT_WINNINGS)
                + (countOfSixCorrect * LottoConstants.SIX_NUMBER_CORRECT_WINNINGS);

        assertThat(lottoResult.winnings()).isEqualTo(expectedWinnings);
    }

    @Test
    @DisplayName("rateOfReturn 호출 시 수익률을 소숫점 이하 2자리로 반환")
    void rateOfReturn() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addCorrectLottoCount(3);
        assertThat(lottoResult.rateOfReturn(14)).isEqualTo(0.35);
    }

    private void addResultCount(LottoResult lottoResult, int correctCount, int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottoResult.addCorrectLottoCount(correctCount);
        }
    }
}
