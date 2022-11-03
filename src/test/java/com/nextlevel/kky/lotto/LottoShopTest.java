package com.nextlevel.kky.lotto;

import com.nextlevel.kky.lotto.domain.LotteryCommission;
import com.nextlevel.kky.lotto.domain.LottoShop;
import com.nextlevel.kky.lotto.model.Lotto;
import com.nextlevel.kky.lotto.model.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @Test
    @DisplayName("로또를 14000원 어치를 구매하면 14를 살수있다")
    public void buyLottoTest() {
        LottoShop lottoShop = new LottoShop(() -> List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = lottoShop.buyLotto(14000);

        assertThat(lottoList.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매한 로또에 대하여 결과를 확인할 수 있다")
    public void calculateWinningStatisticsTest() {
        LottoShop lottoShop = new LottoShop(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottoList = lottoShop.buyLotto(5000);

        WinningStatistics winningStatistics = LotteryCommission.calculateWinningStatistics(winningNumbers, lottoList);
        assertThat(winningStatistics.getFirst()).isEqualTo(5);
    }
}
