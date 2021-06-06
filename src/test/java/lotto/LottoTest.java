package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    Lotto lotto = new Lotto();

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @Test
    void lottoWin() {

        lotto.setLottoWin(LottoWin.FOURTH_PLACE);
        assertThat(lotto.lottoWin()).isEqualTo(LottoWin.FOURTH_PLACE);
    }

    private List<LottoNumber> getTargetLottoWinNumber(LottoWin lottoWin, List<LottoNumber> baseLottoNumber) {
        List<LottoNumber> targetLottoWinNumber = new ArrayList<>();
        // 일치하는 갯수만큼 타겟값에 로또 번호를 넣어줌
        for (int i = 0; i < lottoWin.matchNum(); i++) {
            targetLottoWinNumber.add(baseLottoNumber.get(i));
        }
        // 남은 값들은 불일치 값으로 로또 번호를 넣어줌
        for (int i = baseLottoNumber.size() - 1; i >= lottoWin.matchNum(); i--) {
            targetLottoWinNumber.add(getNotWinLottoNumber(baseLottoNumber));
        }
        return targetLottoWinNumber;
    }

    private LottoNumber getNotWinLottoNumber(List<LottoNumber> lottoNumbers) {
        for (int i = 1; i < 46; i++) {
            if (!lottoNumbers.contains(new LottoNumber(i))) {
                return new LottoNumber(i);
            }
        }
        return new LottoNumber(46);
    }
}