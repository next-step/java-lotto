package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    public void 당첨번호_생성() {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningNumber.isContain(1)).isTrue();
        assertThat(winningNumber.isContain(2)).isTrue();
        assertThat(winningNumber.isContain(3)).isTrue();
        assertThat(winningNumber.isContain(4)).isTrue();
        assertThat(winningNumber.isContain(5)).isTrue();
        assertThat(winningNumber.isContain(6)).isTrue();

        assertThat(winningNumber.isContain(7)).isFalse();
    }
}
