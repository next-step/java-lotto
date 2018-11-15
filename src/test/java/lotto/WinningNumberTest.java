package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    public void 당첨번호만들기() {
        WinningNumber winningNumber = new WinningNumber("1, 5, 10, 20, 25, 33");
       Set<Integer> winnings = winningNumber.getWinningNumbers();

       assertThat(winnings).containsExactly(1, 5, 10, 20, 25, 33);
    }
}