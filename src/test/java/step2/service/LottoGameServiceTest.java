package step2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.domain.Rank;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.domain.Rank.RANK_3;
import static step2.domain.Rank.RANK_4;

class LottoGameServiceTest {


    @DisplayName("수익률 테스트")
    @Test
    void moneyRateTest() {
        LottoGameService lottoGameService = new LottoGameService("1, 2, 3, 4, 5, 6", "7");
        LottoWinners lottoWinners = new LottoWinners();
        lottoWinners.addWiners(RANK_3);

        double result = lottoGameService.moneyProfitRate(1000, lottoWinners);
        assertThat(result).isEqualTo(1500);
    }
}