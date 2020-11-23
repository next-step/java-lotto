package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankingTest {

    @DisplayName("valueOf 를 사용해서 LottoRanking 을 찾을 수 있다")
    @Test
    void valueOf(){
        assertThat(LottoRanking.valueOf(0, false)).isEqualTo(LottoRanking.MISS);
        assertThat(LottoRanking.valueOf(1, false)).isEqualTo(LottoRanking.MISS);
        assertThat(LottoRanking.valueOf(2, false)).isEqualTo(LottoRanking.MISS);
        assertThat(LottoRanking.valueOf(3, false)).isEqualTo(LottoRanking.FIFTH);
        assertThat(LottoRanking.valueOf(4, false)).isEqualTo(LottoRanking.FOURTH);
        assertThat(LottoRanking.valueOf(5, false)).isEqualTo(LottoRanking.THIRD);
        assertThat(LottoRanking.valueOf(5, true)).isEqualTo(LottoRanking.SECOND);
        assertThat(LottoRanking.valueOf(6, false)).isEqualTo(LottoRanking.FIRST);
    }


}