package lotto.domain;

import lotto.context.Rank;
import lotto.util.ManualLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class WinningResultTest {
    List<Lotto> lottoList;
    WinningResult winningResult;

    @BeforeEach
    void create() {
        lottoList = Arrays.asList(new Lotto(new ManualLottoGenerator(Arrays.asList(1,2,3,4,5,6))),
                new Lotto(new ManualLottoGenerator(Arrays.asList(1,12,13,14,15,16))));
        winningResult = new WinningResult("1,2,3,4,5,6", 7);
    }

    @Test
    void getCountByRank() {
        Assertions.assertThat(winningResult.getCountByRank(lottoList, Rank.FIRST))
                .isEqualTo(1);
    }

    @Test
    void getCountByRank_BonusBall() {
        lottoList = Arrays.asList(new Lotto(new ManualLottoGenerator(Arrays.asList(1,2,3,4,5,7))),
                new Lotto(new ManualLottoGenerator(Arrays.asList(1,2,3,4,5,10))));
        Assertions.assertThat(winningResult.getCountByRank(lottoList, Rank.SECOND))
                .isEqualTo(1);
        Assertions.assertThat(winningResult.getCountByRank(lottoList, Rank.THIRD))
                .isEqualTo(1);
    }

    @Test
    void validLottoNumberText() {
        Assertions.assertThatThrownBy(() -> {
            new WinningResult("", 45);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}