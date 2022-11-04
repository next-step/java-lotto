package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또 수동 구매 가능")
    void test1() {
        // given
        LottoMachine lottoMachine = new LottoMachine(Money.of(1000));
        // when
        boolean canBuy = lottoMachine.canBuyLotto(1);
        // then
        assertThat(canBuy).isTrue();
    }

    @Test
    @DisplayName("로또 수동 구매 불가")
    void test2() {
        // given
        LottoMachine lottoMachine = new LottoMachine(Money.of(1000));
        // when
        boolean canBuy = lottoMachine.canBuyLotto(2);
        // then
        assertThat(canBuy).isFalse();
    }

    @Test
    @DisplayName("로또 수동 구매")
    void test3() {
        // given
        LottoMachine lottoMachine = new LottoMachine(Money.of(1000));
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        // when
        Lottos lottos = lottoMachine.buyLottoManually(lottoNumbers);
        // then
        assertThat(lottos.getLottosSize()).isEqualTo(1);
        assertThat(lottos.getLottos()).containsExactly(Lotto.manual(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("로또 자동 구매")
    void test4() {
        // given
        LottoMachine lottoMachine = new LottoMachine(Money.of(5000));
        // when
        Lottos lottos = lottoMachine.buyLottoAuto();
        // then
        assertThat(lottos.getLottosSize()).isEqualTo(5);
    }
    
    @Test
    @DisplayName("통계 구하기")
    void test5() {
        // given
        Money money = Money.of(1000);
        LottoMachine lottoMachine = new LottoMachine(money);
        Lottos lottos = new Lottos(1, 2, 3, 4, 5, 6);
        Lottos lottos2 = new Lottos(7, 8, 9, 10, 11, 12);
        WinningLotto winningLotto = WinningLotto.builder()
                .winningNumbers(1, 2, 3, 4, 5, 6)
                .bonusBall(13)
                .build();
        // when
        Statistic statistic = lottoMachine.calculateStatistic(money, winningLotto, lottos, lottos2);
        // then
        assertThat(statistic.getEarningRate()).isEqualTo(2000000.0);
    }

}
