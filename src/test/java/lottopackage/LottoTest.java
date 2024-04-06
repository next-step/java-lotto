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
        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumber1st = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumber3rd = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        List<Integer> winningNumber4th = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 7, 8));
        List<Integer> winningNumber5th = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Integer> noWinningNumber = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15, 16));

        // when, then
        Assertions.assertThat(lotto.isPrize(winningNumber1st)).isEqualTo(Prize.FIRST);
        Assertions.assertThat(lotto.isPrize(winningNumber3rd)).isEqualTo(Prize.THIRD);
        Assertions.assertThat(lotto.isPrize(winningNumber4th)).isEqualTo(Prize.FOURTH);
        Assertions.assertThat(lotto.isPrize(winningNumber5th)).isEqualTo(Prize.FIFTH);
        Assertions.assertThat(lotto.isPrize(noWinningNumber)).isEqualTo(Prize.SIXTH);


    }
}
