package net.chandol.lotto.domain;

import org.junit.Test;

import static net.chandol.lotto.domain.LottoNumber.direct;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void null여부체크() {
        new WinningNumber(direct(1, 2, 3, 4, 5, 6), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복유효성체크() {
        new WinningNumber(direct(1, 2, 3, 4, 5, 6), 1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void 범위유효성체크() {
        new WinningNumber(direct(1, 2, 3, 4, 5, 6), -3);
    }

    @Test
    public void 당첨번호생성확인() {
        WinningNumber numbers = new WinningNumber(direct(1, 2, 3, 4, 5, 6), 7);

        assertThat(numbers.getLottoNumber().getLottoNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(numbers.getBonusNumber()).isEqualTo(7);
    }

}