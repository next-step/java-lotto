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
        Lotto lotto6 = new Lotto("1, 2, 3, 4, 5, 7");
        Lotto lotto7 = new Lotto("1, 2, 3, 4, 5, 6");

        Lottos lottos = new Lottos(Lists.list(lotto0, lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7));
        WinnerLotto winLotto = new WinnerLotto("1, 2, 3, 4, 5, 6", 7);

        // when
        Map<Rank, Integer> matchCounts = lottoMachine.calculateMatchCount(lottos, winLotto);

        // then
        assertThat(matchCounts.get(Rank.MISS)).isNull();
        assertThat(matchCounts.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(matchCounts.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(matchCounts.get(Rank.THIRD)).isEqualTo(1);
        assertThat(matchCounts.get(Rank.SECOND)).isEqualTo(1);
        assertThat(matchCounts.get(Rank.FIRST)).isEqualTo(1);

    }

    @Test
    void calculateProfit() {
        // given
        Lottos lottos = new Lottos();
        WinnerLotto winLotto = new WinnerLotto("1, 2, 3, 4, 5, 6", 7);

        // when
        BigDecimal profit = lottoMachine.calculateProfit(lottos, winLotto);

        // then
        assertThat(profit).isEqualTo(new BigDecimal(0));
    }

}
