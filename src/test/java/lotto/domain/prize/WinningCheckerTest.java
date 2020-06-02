package lotto.domain.prize;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckerTest {
    @Test
    void 당첨번호_일치개수를_확인한다() {
        WinningChecker winningChecker = new WinningChecker();
        List<Integer> lottoNumber = Arrays.asList(3, 17, 19, 20, 38, 44);
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        int winCount = winningChecker.checkWinNumber(lottoNumber, winNumber);

        assertThat(winCount).isEqualTo(1);

    }

}

