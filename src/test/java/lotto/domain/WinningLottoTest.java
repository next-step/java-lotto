package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또 생성 테스트")
    public void test(){
        List<LottoNumber> winningNumbers = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        Lotto lotto = new Lotto(winningNumbers);

        String[] winningNumberArr = {"1","2","3","4","5","6"};
        WinningLotto winningLotto = new WinningLotto(winningNumberArr, 7);

        assertThat(winningLotto.countWinningNumber(lotto)).isEqualTo(Rank.FIRST);
        assertThat(winningLotto.countWinningNumber(lotto).getCountOfMatch()).isEqualTo(Count.of(6));
    }

    @Test
    @DisplayName("당첨 로또 생성 테스트")
    public void test2(){
        List<LottoNumber> winningNumbers = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        Lotto lotto = new Lotto(winningNumbers);

        String[] winningNumberArr = {"1","2","3","4","5","7"};
        WinningLotto winningLotto = new WinningLotto(winningNumberArr, 6);

        assertThat(winningLotto.countWinningNumber(lotto)).isEqualTo(Rank.SECOND);
        assertThat(winningLotto.countWinningNumber(lotto).getCountOfMatch()).isEqualTo(Count.of(5));
    }

    @Test
    @DisplayName("당첨 로또 생성 테스트")
    public void test3(){
        List<LottoNumber> winningNumbers = Arrays.asList(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
        Lotto lotto = new Lotto(winningNumbers);

        String[] winningNumberArr = {"1","2","3","4","5","7"};
        WinningLotto winningLotto = new WinningLotto(winningNumberArr, 8);

        assertThat(winningLotto.countWinningNumber(lotto)).isEqualTo(Rank.THIRD);
        assertThat(winningLotto.countWinningNumber(lotto).getCountOfMatch()).isEqualTo(Count.of(5));
    }
}
