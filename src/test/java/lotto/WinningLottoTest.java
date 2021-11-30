package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.winning.WinningLottoStats;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private static final List<Lotto> lottoList = Arrays.asList(
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))),
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 10))),
            new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 12, 13, 14))));


    private static final Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @Test
    void setWinningStatsMapTest() {

        WinningLottoStats winningLottoStats = new WinningLottoStats(new Lottos(lottoList), winning);

        assertThat(winningLottoStats.getWinningStatsMap().get(3)).isEqualTo(1);
        assertThat(winningLottoStats.getWinningStatsMap().get(4)).isEqualTo(1);
        assertThat(winningLottoStats.getWinningStatsMap().get(5)).isEqualTo(1);
        assertThat(winningLottoStats.getWinningStatsMap().get(6)).isEqualTo(1);
    }

    @Test
    void profitPercentTest() {

        WinningLottoStats winningLottoStats = new WinningLottoStats(new Lottos(lottoList), winning);
        assertThat(winningLottoStats.getProfitPercent(4000)).isEqualTo("500388.75");

    }
}
