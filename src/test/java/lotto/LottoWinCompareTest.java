package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinCompareTest {
    private static final int FAIL_NUMBER = 45;
    private static final int BONUS_NUMBER = 40;
    List<LottoNumber> baseLottoNums = makeLottoNumberList(LottoWin.FIRST_PLACE, FAIL_NUMBER);

    @Test
    void compareWinning() {
        for (LottoWin lottoWin : LottoWin.values()) {
            List<LottoNumber> targetLottoNums = makeLottoNumberList(lottoWin, FAIL_NUMBER);
            Lotto lotto = new Lotto(targetLottoNums);
            int bonusNumber = lottoWin == LottoWin.SECOND_PLACE ? FAIL_NUMBER : BONUS_NUMBER;
            LottoWin comparedLottoWin = LottoWinCompare.compareWinning(lotto, baseLottoNums, new LottoNumber(bonusNumber));
            assertThat(lottoWin).isEqualTo(comparedLottoWin);
        }
    }

    private List<LottoNumber> makeLottoNumberList(LottoWin lottoWin, int failNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoWin.matchNum(); i++) {
            lottoNumbers.add(new LottoNumber(i + 1));
        }
        for (int i = 6; i > lottoWin.matchNum(); i--) {
            lottoNumbers.add(new LottoNumber(failNumber));
        }
        return lottoNumbers;
    }
}