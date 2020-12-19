package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUP() {
        lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.FIFTH);
        lottoResult.addRank(Rank.FIFTH);
        lottoResult.addRank(Rank.MISS);
    }

    @DisplayName("새로운 당첨 결과값들이 들어오면 기존 결과값에 더한다.")
    @Test
    void update() {
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIRST);
        ranks.add(Rank.THIRD);
        ranks.add(Rank.MISS);

        lottoResult.update(ranks);

        assertThat(lottoResult.sumMatchCount(Rank.FIRST)).isEqualTo(2);
        assertThat(lottoResult.sumMatchCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.sumMatchCount(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoResult.sumMatchCount(Rank.FOURTH)).isZero();
        assertThat(lottoResult.sumMatchCount(Rank.FIFTH)).isEqualTo(2);
        assertThat(lottoResult.sumMatchCount(Rank.MISS)).isEqualTo(2);
    }

    @DisplayName("총 당첨금액을 더해서 리턴한다.")
    @Test
    void sumWinningMoney() {
        // 2_000_000_000 + 30_000_000 + 5_000 + 5_000 + 0
        assertThat(lottoResult.sumWinningMoney()).isEqualTo(2_030_010_000);
    }
}
