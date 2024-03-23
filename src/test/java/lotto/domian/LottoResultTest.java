package lotto.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoResultTest {

    @Test
    @DisplayName("LottoResult 가 생성되면 Map 의 value 는 0으로 초기화되어야 한다.")
    public void whenLottoResultIsInitialized_ThenAllRanksCountsAreZero(){
        LottoResult lottoResult = LottoResult.initializeLottoResult();
        assertThat(lottoResult.getResultCount(LottoRank.FIRST)).isEqualTo(0);
        assertThat(lottoResult.getResultCount(LottoRank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.getResultCount(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoResult.getResultCount(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.getResultCount(LottoRank.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("파라미터인 LottoRank 와 같은 키 value 값을 1을 올린다.")
    public void whenRankIsUpdated_ThenIncrementsCountByOne(){
        LottoResult lottoResult = LottoResult.initializeLottoResult();
        lottoResult.updateResultForRank(LottoRank.FIRST);
        assertThat(lottoResult.getResult().get(LottoRank.FIRST)).isEqualTo(1);
    }


    @Test
    @DisplayName("당첨 총 금액을 리턴한다.")
    public void returnsTotalWinningAmount(){
        LottoResult lottoResult = LottoResult.initializeLottoResult();
        lottoResult.updateResultForRank(LottoRank.THIRD);
        long winningAmount = lottoResult.calculateTotalWinningAmount();
        assertThat(winningAmount).isEqualTo(50000L);
    }

}
