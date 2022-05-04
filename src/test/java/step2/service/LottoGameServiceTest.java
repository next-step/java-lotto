package step2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.domain.Rank;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameServiceTest {

    @DisplayName("로또 당첨번호 추출")
    @Test
    void pickLottoNumberOfWeek() {
        LottoGameService lottoGameService = new LottoGameService();

        List<Integer> result = lottoGameService.pickLottoNumberOfWeek("10, 2, 3, 4, 5, 6");
        assertThat(result).containsExactly(10, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 당첨자들 추출")
    @Test
    void match() {
        LottoGameService lottoGameService = new LottoGameService();
        Lottos lottos = new Lottos(3000, new TestPick(Arrays.asList(10, 2, 3, 4, 5, 9)));
        LottoWinners winners = lottoGameService.match(lottos, Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winners.count(Rank.POSTION_3)).isEqualTo(3);
    }
    
    @DisplayName("수익률 테스트")
    @Test
    void moneyRate() {
        LottoGameService lottoGameService = new LottoGameService();
        LottoWinners lottoWinners = new LottoWinners();
        lottoWinners.refresh(3);

        double result = lottoGameService.moneyProfitRate(1000, lottoWinners);
        assertThat(result).isEqualTo(20);
    }
}