/*
* 클래스 이름:
* 버전 정보:
* 날짜:
* 작성자: SunheeJo
 */

package lottopackage;

import lottopackage.domain.Lotto;
import lottopackage.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("로또 구매 (자동) (1) 6가지 숫자가 맞는지? (2) 1~45 안에 들어가는 값들인지?")
    public void lotto() {
        // given
        Lotto lotto = new Lotto();
        List<Integer> lottoNumber = lotto.getLotto();
        List<Integer> totalLottoNumber = lotto.getLotteryBalls();

        // when, then
        int lottoLength = lottoNumber.size();
        Assertions.assertThat(lottoLength).isEqualTo(6);
        for (int i = 0; i < lottoLength; i++) {
            Assertions.assertThat(totalLottoNumber.contains( lottoNumber.get(i) )).isEqualTo(true);
        }
    }

    @Test
    @DisplayName("lotto.isPrize()")
    public void isPrize() {
        // given
        List<Integer> winningNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Prize[] prize = Prize.values();

        // when
        Lotto winningNumber1st = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winningNumber3rd = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lotto winningNumber4th = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lotto winningNumber5th = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        Lotto noWinningNumber = new Lotto(new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        List<Lotto> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber) );

        // then
        for (int i = 0; i < prize.length; i++) {
            Lotto lotto = lottoGroup.get(i);
            Assertions.assertThat(lotto.isPrize(winningNumber)).isEqualTo(prize[i]);
        }
    }
}
