package lottopackage;

import lottopackage.domain.Lotto;
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
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Prize[] prize = Prize.values();

        // when
        List<Integer> winningNumber1st = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumber4th = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8));
        List<Integer> winningNumber5th = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Integer> noWinningNumber = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16));
        List<List<Integer>> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber) );

        // then
        for (int i = 0; i < prize.length; i++) {
            List<Integer> lotto = lottoGroup.get(i);
            Assertions.assertThat(Prize.isPrize(lotto, winningNumber)).isEqualTo(prize[i]);
        }
    }
}
