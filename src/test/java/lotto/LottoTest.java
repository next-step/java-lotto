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
            List<Integer> lottoNum = lotto.lottoNum();
            List<Integer> win = new ArrayList<>();
            for (int i = 0; i < targetLottoWIn.matchNum(); i++) {
                win.add(lottoNum.get(i));
            }
            for (int i = lottoNum.size() - 1; i >= targetLottoWIn.matchNum(); i--) {
                win.add(lottoNum.get(i) + 100);
            }
            lotto.calculateWin(win);

            assertThat(lotto.lottoWin()).isEqualTo(targetLottoWIn);
        }
    }
}