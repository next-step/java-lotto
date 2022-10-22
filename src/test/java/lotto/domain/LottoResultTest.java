package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoResultTest {

    @Test
    void 등수_확인(){
        LottoResult lottoResult = new LottoResult(
            List.of(
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.FIFTH,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS
            )
        );

        Assertions.assertThat(lottoResult.numberOfFirstRank()).isEqualTo(0L);
        Assertions.assertThat(lottoResult.numberOfSecondRank()).isEqualTo(0L);
        Assertions.assertThat(lottoResult.numberOfThirdRank()).isEqualTo(0L);
        Assertions.assertThat(lottoResult.numberOfFourthRank()).isEqualTo(0L);
        Assertions.assertThat(lottoResult.numberOfFifthRank()).isEqualTo(1L);
    }

    @Test
    void 수익률_확인(){
        LottoResult lottoResult = new LottoResult(
            List.of(
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.FIFTH,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS
            )
        );

        Assertions.assertThat(lottoResult.calculateProfitRate()).isEqualTo(0.35);
    }

    @Test
    void 이득을_봤는지_확인(){
        LottoResult lottoResult = new LottoResult(
            List.of(
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.FIFTH,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS,
                Rank.MISS
            )
        );

        Assertions.assertThat(lottoResult.hasBenefit()).isFalse();
    }
}