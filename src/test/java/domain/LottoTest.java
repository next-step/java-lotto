package domain;

import org.junit.Test;
import util.WinType;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void 당첨_1등() {
        Lotto lotto = Lotto.of(Numbers.of(1, 2, 3, 4, 5, 6), 7);
        Numbers lotteryNumbers = Numbers.of(1, 2, 3, 4, 5, 6);

        WinType type = lotto.figure(lotteryNumbers);

        assertThat(type).isEqualTo(WinType.FIRST);
    }

    @Test
    public void 당첨_2등() {
        Lotto lotto = Lotto.of(Numbers.of(1, 2, 3, 4, 5, 6), 7);
        Numbers lotteryNumbers = Numbers.of(1, 2, 3, 4, 5, 7);

        WinType type = lotto.figure(lotteryNumbers);

        assertThat(type).isEqualTo(WinType.SECOND);
    }

    @Test
    public void 당첨_3등() {
        Lotto lotto = Lotto.of(Numbers.of(1, 2, 3, 4, 5, 6), 7);
        Numbers lotteryNumbers = Numbers.of(1, 2, 3, 4, 5, 10);

        WinType type = lotto.figure(lotteryNumbers);

        assertThat(type).isEqualTo(WinType.THIRD);
    }

    @Test
    public void 당첨_4등() {
        Lotto lotto = Lotto.of(Numbers.of(1, 2, 3, 4, 5, 6), 7);
        Numbers lotteryNumbers = Numbers.of(1, 2, 3, 4, 24, 10);

        WinType type = lotto.figure(lotteryNumbers);

        assertThat(type).isEqualTo(WinType.FOURTH);
    }

    @Test
    public void 당첨_5등() {
        Lotto lotto = Lotto.of(Numbers.of(1, 2, 3, 4, 5, 6), 7);
        Numbers lotteryNumbers = Numbers.of(12, 2, 3, 4, 24, 10);

        WinType type = lotto.figure(lotteryNumbers);

        assertThat(type).isEqualTo(WinType.FIFTH);
    }

    @Test
    public void 실패() {
        Lotto lotto = Lotto.of(Numbers.of(1, 2, 3, 4, 5, 6), 7);
        Numbers lotteryNumbers = Numbers.of(12, 25, 3, 4, 24, 10);

        WinType type = lotto.figure(lotteryNumbers);

        assertThat(type).isEqualTo(WinType.LOSE);
    }
}