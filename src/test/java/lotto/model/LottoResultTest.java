package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @DisplayName("로또 총 당첨금을 계산할 수 있다.")
    @Test
    void 로또_총_당첨금_계산() {
        LottoResult result = new LottoResult(List.of(Rank.THIRD, Rank.FOURTH));
        long totalReward = result.getTotalReward();
        assertThat(totalReward).isEqualTo(55_000);
    }

    @DisplayName("로또 수익률을 계산할 수 있다.")
    @Test
    void 로또_수익률_계산() {
        LottoResult result = new LottoResult(List.of(Rank.FOURTH));
        int ticketCount = 10;
        double rate = result.getRateResult(ticketCount);
        assertThat(rate).isEqualTo((double) Rank.FOURTH.prize() / (1_000 * ticketCount));
    }

    @DisplayName("로또 등수마다 당첨개수 결과를 계산할 수 있다.")
    @Test
    void 로또등수마다_당첨개수_계산() {
        List<Rank> ranks = List.of(Rank.FOURTH, Rank.FOURTH);
        LottoResult lottoResult = new LottoResult(ranks);
        Map<Rank, Integer> rankResult = lottoResult.getRankResult();

        assertThat(rankResult.get(Rank.FOURTH)).isEqualTo(2);
    }
}
