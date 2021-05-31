package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinTest {

    @Test
    void valueOf() {
        assertThat(LottoWin.valueOf(6, false)).isEqualTo(LottoWin.FIRST_PLACE);
        assertThat(LottoWin.valueOf(5, true)).isEqualTo(LottoWin.SECOND_PLACE);
        assertThat(LottoWin.valueOf(5, false)).isEqualTo(LottoWin.THIRD_PLACE);
        assertThat(LottoWin.valueOf(4, false)).isEqualTo(LottoWin.FOURTH_PLACE);
        assertThat(LottoWin.valueOf(4, true)).isEqualTo(LottoWin.FOURTH_PLACE);
    }
}