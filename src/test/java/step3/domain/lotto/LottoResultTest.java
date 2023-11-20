package step3.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 해당_Rank_개수_증가_테스트() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.increaseCount(Rank.FIFTH);

        assertThat(lottoResult.getRankMap().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 여러_Rank_개수_증가_테스트() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.increaseCount(Rank.FIFTH);
        lottoResult.increaseCount(Rank.FIFTH);
        lottoResult.increaseCount(Rank.SECOND);

        assertThat(lottoResult.getRankMap().get(Rank.FIFTH)).isEqualTo(2);
        assertThat(lottoResult.getRankMap().get(Rank.SECOND)).isEqualTo(1);
    }
}
