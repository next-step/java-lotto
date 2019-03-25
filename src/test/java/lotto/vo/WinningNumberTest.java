package lotto.vo;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class WinningNumberTest {
    @Test
    public void 지난주당첨번호입력() {
        WinningNumber winningNumber = new WinningNumber("1,2");
        assertThat(winningNumber.getWinningNumbersSize()).isEqualTo(2);
    }
}