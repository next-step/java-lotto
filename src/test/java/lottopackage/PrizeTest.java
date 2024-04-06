package lottopackage;

import lottopackage.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrizeTest {

    @Test
    @DisplayName("isPrize")
    public void isPrize() {
        // given
        List<Integer> winningNumber1st = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumber4th = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8));
        List<Integer> winningNumber5th = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Integer> noWinningNumber = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16));

        // when, then
        Assertions.assertThat(Prize.isPrize(winningNumber1st, winningNumber1st)).isEqualTo(Prize.FIRST);
        Assertions.assertThat(Prize.isPrize(winningNumber3rd, winningNumber1st)).isEqualTo(Prize.THIRD);
        Assertions.assertThat(Prize.isPrize(winningNumber4th, winningNumber1st)).isEqualTo(Prize.FOURTH);
        Assertions.assertThat(Prize.isPrize(winningNumber5th, winningNumber1st)).isEqualTo(Prize.FIFTH);
        Assertions.assertThat(Prize.isPrize(noWinningNumber, winningNumber1st)).isEqualTo(Prize.SIXTH);
    }
}
