package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void 로또결과는_Rank가_몇개있는지_반환() {
        LottoResult lottoResult = new LottoResult(List.of(
                Rank.FIRST,
                Rank.FIRST,
                Rank.SECOND
        ));

        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(2);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void 로또결과는_이익률을_반환() {
        LottoResult lottoResult = new LottoResult(List.of(
                Rank.FIFTH, // 5000
                Rank.MISS // 0
        ));

        assertThat(lottoResult.getProfitRatio()).isEqualTo(2.5);
    }
}
