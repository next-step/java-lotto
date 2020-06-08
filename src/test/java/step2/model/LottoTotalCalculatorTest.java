package step2.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTotalCalculatorTest {

    @Test
    void countWinners() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(Lotto.newStringLotto("1,2,3,4,5,6"));
        lottoList.add(Lotto.newStringLotto("1,24,3,20,5,40"));
        lottoList.add(Lotto.newStringLotto("1,13,20,23,33,34"));
        lottoList.add(Lotto.newStringLotto("1,13,20,23,33,37"));
        lottoList.add(Lotto.newStringLotto("1,13,20,23,33,40"));
        lottoList.add(Lotto.newStringLotto("5,13,20,23,33,40"));
        lottoList.add(Lotto.newStringLotto("1,13,21,23,33,40"));
        lottoList.add(Lotto.newStringLotto("1,13,20,24,33,40"));
        lottoList.add(Lotto.newStringLotto("7,13,20,24,33,40"));
        lottoList.add(Lotto.newStringLotto("1,7,20,24,33,40"));
        lottoList.add(Lotto.newStringLotto("1,13,23,24,33,40"));
        lottoList.add(Lotto.newStringLotto("1,13,20,24,39,40"));

        Lotto winnerLotto = Lotto.newStringLotto("1,13,20,23,33,34");

        LottoTotalCalculator lottoTotalCalculator = new LottoTotalCalculator();
        Map<WinnerTier, Integer> WinningResult = lottoTotalCalculator.countWinners(lottoList, winnerLotto);

        assertThat(WinningResult.get(WinnerTier.MATCH_SIX)).isEqualTo(1);
        assertThat(WinningResult.get(WinnerTier.MATCH_FIVE)).isEqualTo(2);
        assertThat(WinningResult.get(WinnerTier.MATCH_FOUR)).isEqualTo(4);
        assertThat(WinningResult.get(WinnerTier.MATCH_THREE)).isEqualTo(3);
    }
}