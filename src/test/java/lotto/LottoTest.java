package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        for (LottoWin lottoWin : LottoWin.values()) {
            LottoWin targetLottoWIn = lottoWin;
            List<LottoNumber> lottoNum = lotto.lottoNum();
            List<LottoNumber> win = new ArrayList<>();
            for (int i = 0; i < targetLottoWIn.matchNum(); i++) {
                win.add(lottoNum.get(i));
            }
            for (int i = lottoNum.size() - 1; i >= targetLottoWIn.matchNum(); i--) {
                win.add(new LottoNumber(lottoNum.get(i).value() + 100));
            }
            if (lottoWin == LottoWin.SECOND_PLACE) {
                lotto.calculateWin(win, lottoNum.get(lottoNum.size() - 1));
            }
            if (lottoWin != LottoWin.SECOND_PLACE) {
                lotto.calculateWin(win, new LottoNumber(100));
            }

            assertThat(lotto.lottoWin()).isEqualTo(targetLottoWIn);
        }
    }
}