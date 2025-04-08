package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("번호 일치 개수에 따라 적절한 등수를 가져온다.")
    void shouldReturnCorrectRankBasedOnMatchCount() {
        assertThat(LottoRank.getRank(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.getRank(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.getRank(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.getRank(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.getRank(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.getRank(7, true)).isEqualTo(LottoRank.NONE);
    }

    @Test
    @DisplayName("NONE 등수는 당첨이 아니다.")
    void shouldReturnFalseForNoneRank() {
        assertThat(LottoRank.NONE.isWinning()).isFalse();
    }
    
}
