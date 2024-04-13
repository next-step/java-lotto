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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTest {

    @Test
    @DisplayName("로또 생성자(자동) - (1) 6가지 숫자가 맞는지? (2) 1~45 안에 들어가는 값들인지?")
    public void autoLotto() {
        // given
        Set<Integer> lotteryBalls = new HashSet<>(
                Arrays.stream(IntStream.rangeClosed(1, 45).toArray())
                        .boxed()
                        .collect(Collectors.toSet()));

        // when
        Lotto lotto = new Lotto();
        Set<Integer> lottoNumber = LottoBall.setLottoBallToSetInteger(lotto.getLotto());
        int lottoLength = lottoNumber.size();

        // then
        Assertions.assertThat(lottoLength).isEqualTo(6);
        Assertions.assertThat(lotteryBalls.containsAll(lottoNumber)).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 생성자(수동) (정상적인 값 입력) - (1) 6가지 숫자가 맞는지? (2) 1~45 안에 들어가는 값들인지?")
    public void manualLotto() {
        // given
        Set<Integer> lotteryBalls = new HashSet<>(
                Arrays.stream(IntStream.rangeClosed(1, 45).toArray())
                        .boxed()
                        .collect(Collectors.toSet()));

        // when
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Set<Integer> lottoNumber = LottoBall.setLottoBallToSetInteger(lotto.getLotto());
        int lottoLength = lottoNumber.size();

        // then
        Assertions.assertThat(lottoLength).isEqualTo(6);
        Assertions.assertThat(lotteryBalls.containsAll(lottoNumber)).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 생성자(수동) (잘못된 값 입력) - (1) 로또 숫자가 6개가 아님 (2) 중복 입력 (3) 1~45를 벗어나는 값 입력")
    public void wrongManualLotto() {
        // given
        Set<Integer> lotteryBalls = new HashSet<>(
                Arrays.stream(IntStream.rangeClosed(1, 45).toArray())
                        .boxed()
                        .collect(Collectors.toSet()));

        // when, then
        Assertions.assertThatThrownBy(() -> {
            new Lotto(1, 2, 3, 4, 5, 6, 7);
        }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> {
            new Lotto(1, 1, 1, 1, 1, 1);
        }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> {
            new Lotto(46, 47, 48, 49, 50, 51);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("lotto.isPrize() - 당첨 등수 확인")
    public void isPrize() {
        // given
        Set<LottoBall> winningNumber = new Lotto(1, 2, 3, 4, 5, 6).getLotto();
        LottoBall bonusBall = new LottoBall(45);
        Prize[] prize = Prize.values();

        // when
        Lotto winningNumber1st = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningNumber2nd = new Lotto(1, 2, 3, 4, 5, 45);
        Lotto winningNumber3rd = new Lotto(1, 2, 3, 4, 5, 7);
        Lotto winningNumber4th = new Lotto(1, 2, 3, 4, 7, 8);
        Lotto winningNumber5th = new Lotto(1, 2, 3, 7, 8, 9);
        Lotto noWinningNumber = new Lotto(11, 12, 13, 14, 15, 16);
        List<Lotto> lottoGroup = new ArrayList<>(Arrays.asList(winningNumber1st, winningNumber2nd, winningNumber3rd, winningNumber4th, winningNumber5th, noWinningNumber));

        // then
        for (int i = 0; i < prize.length; i++) {
            Lotto lotto = lottoGroup.get(i);
            Assertions.assertThat(lotto.checkPrize(new WinningNumber(winningNumber, bonusBall))).isEqualTo(prize[i]);
        }
    }
}
