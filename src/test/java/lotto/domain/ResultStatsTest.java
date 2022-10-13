package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultStatsTest {

    List<Lotto> lottoTickets = Arrays.asList(new Lotto(LottoNumber.lottoNumbers().subList(0, 6)));
    WinningNumber winningNumber = new WinningNumber(new Lotto(LottoNumber.lottoNumbers().subList(0, 6)), LottoNumber.lottoNumber(7));

    ResultStats resultStats = new ResultStats(lottoTickets, winningNumber);

    @Test
    @DisplayName("로또 1등부터 낙첨까지 갯수별 당첨 이력 검증")
    void prizeCountsByRank() {
        assertThat(resultStats.countPerPrize()).isEqualTo(Arrays.asList(1, 0, 0, 0, 0, 0));
    }

    @Test
    @DisplayName("로또 당첨금액 수익률 검증")
    void returnOnInvestment() {
        assertThat(resultStats.returnOnInvestment(100000)).isEqualTo(20000.0);
    }
}
