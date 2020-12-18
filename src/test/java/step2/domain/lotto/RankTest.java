package step2.domain.lotto;

import step2.domain.dto.LottoResultDto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2.domain.Rank.*;

public class RankTest {

    @Test
    @DisplayName("당첨 순위 테스트")
    void rankTest() {
        assertThat(getRank(new LottoResultDto(6, false))).isEqualTo(FIRST);
        assertThat(getRank(new LottoResultDto(5, true))).isEqualTo(SECOND);
        assertThat(getRank(new LottoResultDto(5, false))).isEqualTo(THIRD);
        assertThat(getRank(new LottoResultDto(4, true))).isEqualTo(FOURTH);
        assertThat(getRank(new LottoResultDto(3, false))).isEqualTo(FIFTH);
        assertThat(getRank(new LottoResultDto(2, true))).isEqualTo(MISS);
        assertThat(getRank(new LottoResultDto(1, false))).isEqualTo(MISS);
        assertThat(getRank(new LottoResultDto(0, true))).isEqualTo(MISS);
    }
}
