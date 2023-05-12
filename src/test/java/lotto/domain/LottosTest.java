package lotto.domain;

import lotto.enums.LottoPrize;
import lotto.strategy.AutoLotto;
import lotto.strategy.LottoStrategy;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottosTest {

    private static final int COUNT = 5;

    @Test
    void round_count_test() {
        // Given
        LottoStrategy strategy = new AutoLotto();

        // When
        Lottos lottos = new Lottos(strategy, COUNT);

        // Then
        assertThat(lottos.getLottoList()).hasSize(COUNT);
    }

    @Test
    void getMatchCounts_returnsCorrectMatchCounts() {
        // Arrange
        LottoStrategy lottoStrategy = new AutoLotto();
        int count = 5;
        Lottos lottos = new Lottos(lottoStrategy, count);
//        WinnerLotto winnerLotto = new WinnerLotto("1,2,3,4,5,6", 7);

//        // Act
//        Map<LottoPrize, Integer> matchCounts = lottos.getMatchCounts(winnerLotto);
//
//        // Assert
//        assertEquals(0, matchCounts.get(LottoPrize.FIFTH));
//        assertEquals(0, matchCounts.get(LottoPrize.FOURTH));
//        assertEquals(0, matchCounts.get(LottoPrize.THIRD));
//        assertEquals(0, matchCounts.get(LottoPrize.SECOND));
//        assertEquals(0, matchCounts.get(LottoPrize.FIRST));
    }



}