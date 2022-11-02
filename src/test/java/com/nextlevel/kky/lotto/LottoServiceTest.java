package com.nextlevel.kky.lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    @Test
    public void buyLottoTest() {
        LottoService lottoService = new LottoService(() -> List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = lottoService.buyLotto(14000);

        assertThat(lottoList.size()).isEqualTo(14);
        assertThat(lottoList.get(0).getNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void calculateWinningStatisticsTest() {
        LottoService lottoService = new LottoService(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = lottoService.buyLotto(5000);

        WinningStatistics winningStatistics = lottoService.calculateWinningStatistics(winningNumbers, lottoList);
        assertThat(winningStatistics.getFirst()).isEqualTo(5);
    }
}
