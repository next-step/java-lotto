/*
* 클래스 이름:
* 버전 정보:
* 날짜:
* 작성자: SunheeJo
 */

package lottopackage;

import lottopackage.domain.LottoTicket;
import lottopackage.domain.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.*;

public class LottoTest {

    @Test
    @DisplayName("로또 생성자 - (1) 6가지 숫자가 맞는지? (2) 1~45 안에 들어가는 값들인지?")
    public void lotto() {
        // given
        LottoTicket lotto = new LottoTicket();
        Set<Integer> lottoNumber = lotto.getLotto();
        Set<Integer> totalLottoNumber = lotto.getLotteryBalls();

        // when, then
        int lottoLength = lottoNumber.size();
        Assertions.assertThat(lottoLength).isEqualTo(6);
        Assertions.assertThat(totalLottoNumber.containsAll ( lottoNumber )).isEqualTo(true);
    }

    @Test
    @DisplayName("lotto.isPrize() - 당첨 등수 확인")
    public void isPrize() {
        // given
        Set<Integer> winningNumber = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Prize[] prize = Prize.values();

        // when
        LottoTicket winningNumber1st = new LottoTicket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTicket winningNumber3rd = new LottoTicket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        LottoTicket winningNumber4th = new LottoTicket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        LottoTicket winningNumber5th = new LottoTicket(new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        LottoTicket noWinningNumber = new LottoTicket(new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        List<LottoTicket> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber) );

        // then
        for (int i = 0; i < prize.length; i++) {
            LottoTicket lotto = lottoGroup.get(i);
            Assertions.assertThat(lotto.isPrize(winningNumber)).isEqualTo(prize[i]);
        }
    }
}
