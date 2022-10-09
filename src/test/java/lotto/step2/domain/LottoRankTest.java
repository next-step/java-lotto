package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {
    @Test
    @DisplayName("번호 일치 개수")
    void count_of_match_number() {
        assertThat(LottoRank.FIFTH.getCountOfMatchNumber()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("상금")
    void reward() {
        assertThat(LottoRank.SECOND.getReward()).isEqualTo(30_000_000);
    }
    
    @Test
    @DisplayName("해당 순위 개수")
    void count_of_lotto_rank() {
        int countOfLottoRanks = LottoRank.THIRD.getCountOfLottoRanks(Arrays.asList(LottoRank.THIRD, LottoRank.FIFTH, LottoRank.THIRD));
        assertThat(countOfLottoRanks).isEqualTo(2);
    }
    
    @Test
    @DisplayName("순위 구하기")
    void value_of() {
        LottoRank lottoRank = LottoRank.valueOf(5, true);
        assertThat(lottoRank).isEqualTo(LottoRank.SECOND);
    }
}