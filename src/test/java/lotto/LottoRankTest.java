package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("번호 일치 개수에 따라 적절한 등수를 가져온다.")
    void shouldReturnCorrectRankBasedOnMatchCount() {
        assertThat(LottoRank.getRank(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.getRank(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.getRank(7, true)).isEqualTo(null);
    }

    @Test
    @DisplayName("toString()이 올바른 형식으로 문자열을 반환한다.")
    void shouldReturnCorrectStringFormat() {
        assertThat(LottoRank.FIRST.toString()).isEqualTo("6개 일치 (2000000000원)");
    }
}
