package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    @DisplayName("일치하는 번호 개수 + 보너스번호 일치 여부에 따른 로또 당첨 등수를 반환한다.")
    void 로또_당첨_등수_반환() {
        LottoRank second = LottoRank.valueOf(5, true);
        LottoRank third = LottoRank.valueOf(5, false);

        assertThat(second.getCountOfMatch()).isEqualTo(5);
        assertThat(second.getWinningPrice()).isEqualTo(30_000_000);

        assertThat(third.getCountOfMatch()).isEqualTo(5);
        assertThat(third.getWinningPrice()).isEqualTo(1_500_000);
    }
}