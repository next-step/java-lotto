package rankingtwolotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rankingtwolotto.domain.LottoRanking;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingTest {

    @DisplayName("3개 일치")
    @Test
    void coincideThree() {
        assertThat(LottoRanking.THREE.getCompensation()).isEqualTo(5000);
    }

    @DisplayName("4개 일치")
    @Test
    void coincideFour() {
        assertThat(LottoRanking.FOUR.getCompensation()).isEqualTo(50000);
    }

    @DisplayName("5개 일치")
    @Test
    void coincideFive() {
        assertThat(LottoRanking.FIVE.getCompensation()).isEqualTo(1500000);
    }

    @DisplayName("6개 일치")
    @Test
    void coincideSix() {
        assertThat(LottoRanking.SIX.getCompensation()).isEqualTo(2000000000);
    }

    @DisplayName("5개 + 보너스볼 일치")
    @Test
    void coincideBonus() {
        assertThat(LottoRanking.BONUS.getCompensation()).isEqualTo(30000000);
    }
}
