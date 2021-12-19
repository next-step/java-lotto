package lotto;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void buyLottos_with_money() {
        // given
        long inputMoney = 6000;

        // when
        Lottos lottos = lottoMachine.buyLottos(inputMoney);

        // then
        assertThat(lottos).isNotNull();
        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @Test
    void calculateMatchCount() {
        // given
        Lotto lotto0 = new Lotto("7, 8, 9, 10, 11, 12");
        Lotto lotto1 = new Lotto("1, 8, 9, 10, 11, 12");
        Lotto lotto2 = new Lotto("1, 2, 9, 10, 11, 12");
        Lotto lotto3 = new Lotto("1, 2, 3, 10, 11, 12");
        Lotto lotto4 = new Lotto("1, 2, 3, 4, 11, 12");
        Lotto lotto5 = new Lotto("1, 2, 3, 4, 5, 12");
        Lotto lotto6 = new Lotto("1, 2, 3, 4, 5, 6");

        Lottos lottos = new Lottos(Lists.list(lotto0, lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");

        // when
        Map<Integer, Integer> matchCounts = lottoMachine.calculateMatchCount(lottos, winLotto);

        // then
        assertThat(matchCounts.get(0)).isNull();
        assertThat(matchCounts.get(1)).isNull();
        assertThat(matchCounts.get(2)).isNull();
        assertThat(matchCounts.get(3)).isEqualTo(1);
        assertThat(matchCounts.get(4)).isEqualTo(1);
        assertThat(matchCounts.get(5)).isEqualTo(1);
        assertThat(matchCounts.get(6)).isEqualTo(1);
    }

    @Test
    void calculateProfit() {
        // given
        Lottos lottos = new Lottos();
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");

        // when
        BigDecimal profit = lottoMachine.calculateProfit(lottos, winLotto);

        // then
        assertThat(profit).isEqualTo(new BigDecimal(0));
    }

}
