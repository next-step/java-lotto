package lotto;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottosTest {

    @Test
    void createLottos() {
        // given
        List<Lotto> lottoList = lottos(4);

        // when
        Lottos lottos = new Lottos(lottoList);

        // then
        assertThat(lottos.count()).isEqualTo(4);
    }

    @Test
    void addNewLotto() {
        // given
        Lottos lottos = new Lottos(lottos(3));
        List<Number> lottoNumbers = Lists.list(Number.ONE, Number.TWO, Number.THREE, Number.FOUR, Number.FIVE, Number.SIX);

        // when
        lottos.addNewLotto(lottoNumbers);

        // then
        assertThat(lottos.count()).isEqualTo(4);
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
        Map<Rank, Integer> matchCounts = lottos.calculateMatchCount(winLotto);

        // then
        Assertions.assertThat(matchCounts.get(Rank.MISS)).isEqualTo(3);
        Assertions.assertThat(matchCounts.get(Rank.FIFTH)).isEqualTo(1);
        Assertions.assertThat(matchCounts.get(Rank.FOURTH)).isEqualTo(1);
        Assertions.assertThat(matchCounts.get(Rank.THIRD)).isEqualTo(1);
        Assertions.assertThat(matchCounts.get(Rank.SECOND)).isEqualTo(1);
        Assertions.assertThat(matchCounts.get(Rank.FIRST)).isEqualTo(1);

    }

    @Test
    void calculateProfit() {
        // given
        Lottos lottos = new Lottos(lottos(3));
        WinnerLotto winnerLotto = new WinnerLotto("1, 2, 3, 7, 8, 9", 10);

        // when
        BigDecimal profit = lottos.calculateProfit(winnerLotto, new Money(1000));

        // then
        assertThat(profit).isEqualTo(new BigDecimal("5.000"));
    }

    List<Lotto> lottos(int count) {
        Numbers numbers = new Numbers("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

}
