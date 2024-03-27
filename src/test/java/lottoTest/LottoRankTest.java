package lottoTest;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("2개를 미만이면 LOSE")
    void COUNT_UNDER_THREE_IS_LOSE() {
        LottoRank result = LottoRank.isLottoRank(1, true);
        assertThat(result).isEqualTo(LottoRank.LOSE);
    }

    @Test
    @DisplayName("3개를 맞추면 5등이다.")
    void COUNT_THREE_IS_FIFTH_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(3, true);
        assertThat(result).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("4개를 맞추면 4등이다.")
    void COUNT_THREE_IS_FOURTH_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(4, true);
        assertThat(result).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("5개를 맞추고 보너스 번호를 맞추지 못하면 3등이다.")
    void COUNT_FOUR_IS_THIRD_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(5, false);
        assertThat(result).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("5개를 맞추고 보너스 번호가 맞으면 2등이다.")
    void COUNT_FIVE_IS_SECOND_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(5, true);
        assertThat(result).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("6개를 맞추면 1등이다.")
    void COUNT_SIX_IS_FIRST_PRIZE() {
        LottoRank result = LottoRank.isLottoRank(6, false);
        assertThat(result).isEqualTo(LottoRank.FIRST);
    }

}
