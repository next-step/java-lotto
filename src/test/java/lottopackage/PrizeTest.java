package lottopackage;

import lottopackage.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PrizeTest {

    @Test
    @DisplayName("isPrize() - 당첨 등수 확인")
    public void isPrize() {
        // given
        Set<Integer> winningNumber = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Prize[] prize = Prize.values();

        // when
        Set<Integer> winningNumber1st = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> winningNumber3rd = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        Set<Integer> winningNumber4th = new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8));
        Set<Integer> winningNumber5th = new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        Set<Integer> noWinningNumber = new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16));
        List<Set<Integer>> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber) );

        // then
        for (int i = 0; i < prize.length; i++) {
            Set<Integer> lotto = lottoGroup.get(i);
            Assertions.assertThat(Prize.isPrize(lotto, winningNumber)).isEqualTo(prize[i]);
        }
    }
}
