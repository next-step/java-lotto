package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    public void 당첨번호_생성() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(10));

        assertThat(winningNumber.isContain(new LottoNumber(1))).isTrue();
        assertThat(winningNumber.isBonusMatched(new LottoNumber(10))).isTrue();

        assertThat(winningNumber.isContain(new LottoNumber(7))).isFalse();
        assertThat(winningNumber.isBonusMatched(new LottoNumber(11))).isFalse();
    }
}
