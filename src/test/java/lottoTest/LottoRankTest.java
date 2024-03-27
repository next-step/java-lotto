package lottoTest;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("3개를 미만이면 LOSE")
    void COUNT_UNDER_THREE_IS_LOSE() {
        LottoRank result = LottoRank.isLottoRank(1);
        assertThat(result).isEqualTo(LottoRank.LOSE);
        assertThat(result.getCount()).isEqualTo(0);
        assertThat(result.getPrize()).isEqualTo(0);
    }

    @Test
    @DisplayName("3개를 맞추면 4등이다.")
    void COUNT_THREE_IS_FOURTH_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(3);
        assertThat(result).isEqualTo(LottoRank.FOURTH);
        assertThat(result.getCount()).isEqualTo(3);
        assertThat(result.getPrize()).isEqualTo(5_000);
    }

    @Test
    @DisplayName("4개를 맞추면 3등이다.")
    void COUNT_FOUR_IS_THIRD_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(4);
        assertThat(result).isEqualTo(LottoRank.THIRD);
        assertThat(result.getCount()).isEqualTo(4);
        assertThat(result.getPrize()).isEqualTo(50_000);
    }

    @Test
    @DisplayName("5개를 맞추면 2등이다.")
    void COUNT_FIVE_IS_SECOND_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(5);
        assertThat(result).isEqualTo(LottoRank.SECOND);
        assertThat(result.getCount()).isEqualTo(5);
        assertThat(result.getPrize()).isEqualTo(1_500_000);
    }

    @Test
    @DisplayName("4개를 맞추면 3등이다.")
    void COUNT_SIX_IS_FIRST_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(6);
        assertThat(result).isEqualTo(LottoRank.FIRST);
        assertThat(result.getCount()).isEqualTo(6);
        assertThat(result.getPrize()).isEqualTo(2_000_000_000);
    }

}
