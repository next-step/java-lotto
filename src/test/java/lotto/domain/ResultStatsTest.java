package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultStatsTest {

    private final List<LottoNumber> lottoNumbers = LottoNumber.lottoNumbers().subList(0, 6);
    private final LottoNumber bonusNumber = LottoNumber.lottoNumber(7);
    private final List<Lotto> lottoTickets = Arrays.asList(new Lotto(lottoNumbers), new Lotto(lottoNumbers));
    private final WinningLotto winningLotto = new WinningLotto(new Lotto(lottoNumbers), bonusNumber);
    private final ResultStats resultStats = new ResultStats(lottoTickets, winningLotto);

    @Test
    @DisplayName("로또 1등부터 낙첨까지 갯수별 당첨 이력 검증")
    void prizeCountsByRank() {
        assertThat(resultStats.countPerPrize())
                .isEqualTo(Arrays.asList(2, 0, 0, 0, 0, 0));
    }

    @Test
    @DisplayName("로또 당첨금액 수익률 검증")
    void returnOnInvestment() {
        assertThat(resultStats.returnOnInvestment(2000))
                .isEqualTo(2000000.0);
    }
}
