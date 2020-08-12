package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoWinningAndPrizeMoney.FIFTH;
import static lotto.domain.LottoWinningAndPrizeMoney.FIRST;
import static lotto.domain.LottoWinningAndPrizeMoney.FOURTH;
import static lotto.domain.LottoWinningAndPrizeMoney.LOSE;
import static lotto.domain.LottoWinningAndPrizeMoney.SECOND;
import static lotto.domain.LottoWinningAndPrizeMoney.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningAndPrizeMoneyTest {
    @DisplayName("로또 맞은 갯수와 enum 필드 매칭 여부 확인")
    @Test
    void test() {
        assertThat(LottoWinningAndPrizeMoney.confirmWin(6,false)).isEqualTo(FIRST);
        assertThat(LottoWinningAndPrizeMoney.confirmWin(5,true)).isEqualTo(SECOND);
        assertThat(LottoWinningAndPrizeMoney.confirmWin(5,false)).isEqualTo(THIRD);
        assertThat(LottoWinningAndPrizeMoney.confirmWin(4, false)).isEqualTo(FOURTH);
        assertThat(LottoWinningAndPrizeMoney.confirmWin(3, false)).isEqualTo(FIFTH);
        assertThat(LottoWinningAndPrizeMoney.confirmWin(0, false)).isEqualTo(LOSE);
        assertThat(LottoWinningAndPrizeMoney.confirmWin(-1, false)).isEqualTo(LOSE);
    }
}