package lottogame.domain;

import lottogame.domain.lotto.*;
import lottogame.domain.strategy.PredefinedLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("생성 개수만큼 로또를 생성한다.")
    void create(int count) {
        Lottos lottos = new Lottos(count);

        assertEquals(count, lottos.getLottos().size());
    }


    @DisplayName("당첨 통계 계산")
    @Test
    void calculateWinningStatistics() {
        List<Lotto> predefinedLottos = Arrays.asList(
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6")),
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,7")),
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,8"))
        );
        Lottos lottos = new Lottos(predefinedLottos);
        Lotto winingLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusNumber = new LottoNumber(7);

        Map<Rank, Integer> actual = lottos.calculateWinningStatistics(new WinningLotto(winingLotto, bonusNumber));

        assertThat(actual).containsOnly(
                entry(Rank.FIRST, 1),
                entry(Rank.SECOND, 1),
                entry(Rank.THIRD, 1)
        );
    }

    @DisplayName("총 상금 계산")
    @Test
    void calculateTotalPrizeAmount() {
        List<Lotto> predefinedLottos = Arrays.asList(
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6")),
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,7")),
                new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,8"))
        );
        Lottos lottos = new Lottos(predefinedLottos);
        Lotto winingLotto = new Lotto(new PredefinedLottoNumberStrategy("1,2,3,4,5,6"));
        LottoNumber bonusNumber = new LottoNumber(7);

        double actual = lottos.calculateTotalPrizeAmount(new WinningLotto(winingLotto, bonusNumber));
        double expected = Rank.FIRST.getPrizeMoney() + Rank.SECOND.getPrizeMoney() + Rank.THIRD.getPrizeMoney();

        assertEquals(expected, actual);
    }

}