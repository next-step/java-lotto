/*
* 클래스 이름:
* 버전 정보:
* 날짜:
* 작성자: SunheeJo
 */

package lottopackage;

import lottopackage.domain.Lotto;
import lottopackage.domain.LottoBall;
import lottopackage.domain.Prize;
import lottopackage.domain.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTest {

    @Test
    @DisplayName("로또 생성자 - (1) 6가지 숫자가 맞는지? (2) 1~45 안에 들어가는 값들인지?")
    public void lotto() {
        // given
        Lotto lotto = new Lotto();
        Set<Integer> lottoNumber = LottoBall.setLottoBallToSetInteger( lotto.getLotto() );
        Set<Integer> lotteryBalls = new HashSet<>(
                Arrays.stream(IntStream.rangeClosed(1, 45).toArray())
                        .boxed()
                        .collect(Collectors.toSet()));

        // when, then
        int lottoLength = lottoNumber.size();
        Assertions.assertThat(lottoLength).isEqualTo(6);
        Assertions.assertThat(lotteryBalls.containsAll ( lottoNumber )).isEqualTo(true);
    }

    @Test
    @DisplayName("lotto.isPrize() - 당첨 등수 확인")
    public void isPrize() {
        // given
        Set<LottoBall> winningNumber = new Lotto( new HashSet<>( Arrays.asList(1, 2, 3, 4, 5, 6))).getLotto();
        LottoBall bonusBall = new LottoBall(45);
        Prize[] prize = Prize.values();

        // when
        Lotto winningNumber1st = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto winningNumber2nd = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 45)));
        Lotto winningNumber3rd = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lotto winningNumber4th = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lotto winningNumber5th = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        Lotto noWinningNumber = new Lotto(new HashSet<>(Arrays.asList(11, 12, 13, 14, 15, 16)));
        List<Lotto> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber2nd, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber) );

        // then
        for (int i = 0; i < prize.length; i++) {
            Lotto lotto = lottoGroup.get(i);
            Assertions.assertThat(lotto.checkPrize(new WinningNumber(winningNumber, bonusBall))).isEqualTo(prize[i]);
        }
    }
}
