package lotto.dto;

import lotto.domain.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsValueTest {

    @DisplayName("LottoStatisticsValue 생성 테스트")
    @Test
    void of() {
        assertThat(LottoStatisticsValue.of(LottoRank.FIFTH, 1L))
                .isEqualToComparingFieldByField(LottoStatisticsValue.of(LottoRank.FIFTH, 1L));
    }
}
