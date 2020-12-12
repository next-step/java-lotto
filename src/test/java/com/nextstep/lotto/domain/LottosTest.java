package com.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("Lotto 갯수 확인")
    @Test
    void count() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Lotto> list = Arrays.asList(new Lotto(numbers),new Lotto(numbers));
        Lottos lottos = new Lottos(list);
        assertThat(lottos.count()).isEqualTo(2);
    }

    @DisplayName("Statistic 정상 반환 확인")
    @Test
    void getStatistics() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(numbers)));
        LottoStatistics statistics = lottos.getStatistics("1,2,3,4,5,6");

        assertThat(statistics.getCount(LottoWinning.WIN_1ST)).isEqualTo(1);
        assertThat(statistics.getCount(LottoWinning.WIN_3RD)).isEqualTo(0);
        assertThat(statistics.getCount(LottoWinning.WIN_4TH)).isEqualTo(0);
        assertThat(statistics.getCount(LottoWinning.WIN_5TH)).isEqualTo(0);
        assertThat(statistics.getCount(LottoWinning.RETIRE)).isEqualTo(0);
    }

}
