package automaticlotto;

import automaticlotto.domain.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingTest {

    @DisplayName("3개 맞춤")
    @Test
    void lottoRankingTest_3() {
        int reward = LottoRanking.THREE.getCompensation();
        assertThat(reward).isEqualTo(5000);
    }

    @DisplayName("4개 맞춤")
    @Test
    void lottoRankingTest_4() {
        int reward = LottoRanking.FOUR.getCompensation();
        assertThat(reward).isEqualTo(50000);
    }

    @DisplayName("5개 맞춤")
    @Test
    void lottoRankingTest_5() {
        int reward = LottoRanking.FIVE.getCompensation();
        assertThat(reward).isEqualTo(1500000);
    }

    @DisplayName("6개 맞춤")
    @Test
    void lottoRankingTest_6() {
        int reward = LottoRanking.SIX.getCompensation();
        assertThat(reward).isEqualTo(2000000000);
    }

    @DisplayName("맞는거 없음")
    @Test
    void lottoRankingTest_0() {
        int reward = LottoRanking.MISMATCH.getCompensation();
        assertThat(reward).isEqualTo(0);
    }

}
