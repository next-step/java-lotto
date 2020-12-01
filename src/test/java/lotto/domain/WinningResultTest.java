package lotto.domain;

import lotto.context.Rank;
import lotto.util.ManualLottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class WinningResultTest {

    @Test
    void getCountByRank() {
        List<Lotto> lottoList = Arrays.asList(new Lotto(new ManualLottoGenerator(Arrays.asList(1,2,3,4,5,6))),
                new Lotto(new ManualLottoGenerator(Arrays.asList(1,12,13,14,15,16))));
        WinningResult winningResult = new WinningResult("1,2,3,4,5,6");
        Assertions.assertThat(winningResult.getCountByRank(lottoList, Rank.FIRST))
                .isEqualTo(1);
    }

    @Test
    void validLottoNumberText() {
        Assertions.assertThatThrownBy(() -> {
            new WinningResult("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}