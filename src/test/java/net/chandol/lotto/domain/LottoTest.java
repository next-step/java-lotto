package net.chandol.lotto.domain;

import net.chandol.lotto.type.LottoPrize;
import net.chandol.lotto.value.WinningNumber;
import org.junit.Test;

import static net.chandol.lotto.value.LottoNumber.direct;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void Null유효성_확인() {
        new Lotto(null);
    }

    @Test
    public void 매칭결과반환() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(direct(2, 3, 4, 5, 6, 7), 8);

        LottoPrize lottoPrize = lotto.getMatchingLottoPrize(winningNumber);
        assertThat(lottoPrize).isEqualTo(LottoPrize._3);
    }
}