package lottopackage;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoBall;
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
        Set<LottoBall> winningNumber = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 6))).getLotto();
        LottoBall bonusBall = new LottoBall(45);
        Prize[] prize = Prize.values();

        // when
        Set<LottoBall> winningNumber1st = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 6))).getLotto();
        Set<LottoBall> winningNumber2nd = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 45))).getLotto();
        Set<LottoBall> winningNumber3rd = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 7))).getLotto();
        Set<LottoBall> winningNumber4th = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 7, 8))).getLotto();
        Set<LottoBall> winningNumber5th = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 7, 8, 9))).getLotto();
        Set<LottoBall> noWinningNumber = new Lotto( new HashSet<>( Arrays.asList(11, 12, 13, 14, 15, 16))).getLotto();
        List<Set<LottoBall>> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber2nd, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber) );

        // then
        for (int i = 0; i < prize.length; i++) {
            Set<LottoBall> lotto = lottoGroup.get(i);
            Assertions.assertThat(Prize.isPrize(lotto, winningNumber, bonusBall)).isEqualTo(prize[i]);
        }
    }
}
