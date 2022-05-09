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
        LottoWinners lottoWinners = new LottoWinners();
        lottoWinners.add(RANK_3);

        Double rate = lottoWinners.rate(10_000);
        assertThat(rate).isEqualTo(150);
    }
}