package lottopackage;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoBall;
import lottopackage.domain.LottoGroup;
import lottopackage.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LottoGroupTest {

    @Test
    @DisplayName("LottoGroup 내 모든 Lotto의 당첨 등수 확인")
    public void isPrize() {
        // given
        Set<LottoBall> winningNumber = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 6))).getLotto();
        LottoBall bonusBall = new LottoBall(45);
        Prize[] prizeGroup = Prize.values();

        // when
        Lotto winningNumber1st = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winningNumber2nd = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 45)));
        Lotto winningNumber3rd = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lotto winningNumber4th = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lotto winningNumber5th = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        Lotto noWinningNumber = new Lotto(new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        LottoGroup lottoGroup = new LottoGroup(new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber2nd, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber)));

        List<Prize> prizes = lottoGroup.isWinning(winningNumber, bonusBall);


        // then
        for (int i = 0; i < prizes.size(); i++) {
            Assertions.assertThat(prizes.get(i)).isEqualTo(prizeGroup[i]);
            System.out.println(prizes.get(i).name());
        }
    }
}
